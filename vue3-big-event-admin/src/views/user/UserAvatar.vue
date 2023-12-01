<script setup>
import { ref } from 'vue'
import { Plus, Upload } from '@element-plus/icons-vue'
import { useUserStore } from '@/stores/modules/user'
import { userUpdateAvatarService } from '@/api/user.js'

const userStore = useUserStore()
const uploadRef = ref()
const imgUrl = ref(userStore.user.user_pic)
const onSelectFile = (uploadFile) => {
  // 处理图片实时预览
  // imgUrl.value = URL.createObjectURL(uploadFile.raw)
  // 基于 FileReader 读取图片做预览
  const reader = new FileReader()
  reader.readAsDataURL(uploadFile.raw)
  reader.onload = () => {
    imgUrl.value = reader.result
    // 64位的图片字符串
    // console.log(imgUrl.value)
  }
}

// 上传头像
const onUpdateAvatar = async () => {
  // 发请求更新头像
  await userUpdateAvatarService(imgUrl.value)
  // 重新渲染
  await userStore.getUser()
  // 提示用户
  ElMessage.success('上传成功')
}
</script>
<template>
  <pageContainer title="更换头像">
    <el-upload
      ref="uploadRef"
      class="avatar-uploader"
      :auto-upload="false"
      :show-file-list="false"
      :on-change="onSelectFile"
    >
      <img v-if="imgUrl" :src="imgUrl" class="avatar" />
      <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
    </el-upload>
    <el-button
      @click="uploadRef.$el.querySelector('input').click()"
      :icon="Plus"
      type="primary"
      >选择图片</el-button
    >
    <el-button @click="onUpdateAvatar" :icon="Upload" type="success"
      >上传头像</el-button
    >
  </pageContainer>
</template>
<style lang="scss" scoped>
.avatar-uploader {
  :deep() {
    .avatar {
      width: 278px;
      height: 278px;
      display: block;
    }
    .el-upload {
      margin-bottom: 20px;
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
      width: 278px;
      height: 278px;
      text-align: center;
    }
  }
}
</style>
