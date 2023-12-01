<script setup>
import { nextTick, ref } from 'vue'
// import { onMounted } from 'vue'
import channelselect from './TheChannelSelect.vue'
import { Plus } from '@element-plus/icons-vue'
import {
  artPublishService,
  artGetDetailService,
  artEditService
} from '@/api/article.js'
import { QuillEditor } from '@vueup/vue-quill'
import '@vueup/vue-quill/dist/vue-quill.snow.css'
import { baseURL } from '@/utils/request.js'
import axios from 'axios'
// 抽屉显示隐藏
const visibleDrawer = ref(false)

const defaultForm = {
  title: '', // 标题
  cate_id: '', // 分类
  cover_img: '', // 封面图片 file对象
  content: '', // string 内容
  state: '' //状态
}
const formModel = ref({
  title: '', // 标题
  cate_id: '', // 分类
  cover_img: '', // 封面图片 file对象
  content: '', // string 内容
  state: '' //状态
})

// 上传文件
const imgUrl = ref('') // 图片地址
const onSelectFile = (uploadFile) => {
  // console.log(uploadFile)
  // 实现预览图片
  imgUrl.value = URL.createObjectURL(uploadFile.raw)
  // 将图片对象存入formModel.value.cover_img 用于提交
  formModel.value.cover_img = uploadFile.raw
}

// 声明富文本编辑器的数据
const editorRef = ref()
// 声明打开抽屉的方法
const open = async (row) => {
  visibleDrawer.value = true
  if (row.id) {
    // 需要基于row.id 发请求，获取编辑对应的详情数据，进行回显
    const res = await artGetDetailService(row.id)
    formModel.value = res.data.data
    // 拼接图片地址，单独处理图片回显
    // baseURL = 'http://big-event-vue-api-t.itheima.net'
    imgUrl.value = baseURL + formModel.value.cover_img
    // 注意：提交到后台，需要的数据格式，是file对象格式
    // 需要将网络图片地址 => 转换成 file对象， 存储起来
    const file = await imageUrlToFile(imgUrl.value, formModel.value.cover_img)
    formModel.value.cover_img = file
    console.log('编辑回显', res)
  } else {
    formModel.value = { ...defaultForm } // 数据置空
    // 图片的url置空，富文本编辑器也是
    imgUrl.value = ''
    // 使用onMounted确保在组件挂载后执行
    nextTick(() => {
      editorRef.value.setHTML('')
    })
  }
}

// 将网络图片地址转换为File对象
async function imageUrlToFile(url, fileName) {
  try {
    // 第一步：使用axios获取网络图片数据
    const response = await axios.get(url, { responseType: 'arraybuffer' })
    const imageData = response.data

    // 第二步：将图片数据转换为Blob对象
    const blob = new Blob([imageData], {
      type: response.headers['content-type']
    })

    // 第三步：创建一个新的File对象
    const file = new File([blob], fileName, { type: blob.type })

    return file
  } catch (error) {
    console.error('将图片转换为File对象时发生错误:', error)
    throw error
  }
}

// 处理发布
const emit = defineEmits(['success'])
const onPublish = async (state) => {
  formModel.value.state = state
  // 接口需要的是一个formData 对象
  // 需要将formModel 对象转换成 formData对象
  const fd = new FormData()
  for (let key in formModel.value) {
    fd.append(key, formModel.value[key])
  }
  // 发送接口请求
  if (formModel.value.id) {
    // 编辑操作
    await artEditService(fd)
    ElMessage.success('修改成功')
    emit('success', 'edit')
  } else {
    // 添加操作
    console.log('添加操作')
    await artPublishService(fd)
    ElMessage.success('添加成功')
    // 通知父组件，添加成功，需要切换到最后一页
    emit('success', 'add')
  }
  visibleDrawer.value = false
}
defineExpose({
  open
})
</script>
<template>
  <el-drawer
    v-model="visibleDrawer"
    :title="formModel.id ? '编辑文章' : '添加文章'"
    direction="rtl"
    size="50%"
  >
    <!-- 发表文章表单 -->
    <el-form :model="formModel" ref="formRef" label-width="100px">
      <el-form-item label="文章标题" prop="title">
        <el-input v-model="formModel.title" placeholder="请输入标题"></el-input>
      </el-form-item>
      <el-form-item label="文章分类" prop="cate_id">
        <channelselect v-model="formModel.cate_id" width="100%"></channelselect>
      </el-form-item>
      <el-form-item label="文章封面" prop="cover_img">
        <!-- 头像上传：需要关闭自动上传以及配置参数 -->
        <el-upload
          class="avatar-uploader"
          :show-file-list="false"
          :auto-upload="false"
          :on-change="onSelectFile"
        >
          <img v-if="imgUrl" :src="imgUrl" class="avatar" />
          <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
        </el-upload>
      </el-form-item>
      <el-form-item label="文章内容" prop="content">
        <div class="editor">
          <QuillEditor
            ref="editorRef"
            theme="snow"
            v-model:content="formModel.content"
            content-type="html"
          />
        </div>
      </el-form-item>
      <el-form-item>
        <el-button @click="onPublish('已发布')" type="primary">发布</el-button>
        <el-button @click="onPublish('草稿')" type="info">草稿</el-button>
      </el-form-item>
    </el-form>
  </el-drawer>
</template>

<style lang="scss" scoped>
.avatar-uploader {
  :deep() {
    .avatar {
      width: 178px;
      height: 178px;
      display: block;
    }
    .el-upload {
      border: 1px dashed var(--el-border-color);
      border-radius: 6px;
      cursor: pointer;
      position: relative;
      overflow: hidden;
      transition: var(--el-transition-duration-fast);
    }
    .el-upload:hover {
      border-color: var(--el-color-primary);
    }
    .el-icon.avatar-uploader-icon {
      font-size: 28px;
      color: #8c939d;
      width: 178px;
      height: 178px;
      text-align: center;
    }
  }
}

.editor {
  width: 100%;
  :deep(.ql-editor) {
    min-height: 200px;
  }
}
</style>
