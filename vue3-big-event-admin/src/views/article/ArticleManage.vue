<script setup>
import { ref } from 'vue'
import { Edit, Delete } from '@element-plus/icons-vue'
import channelselect from './components/TheChannelSelect.vue'
import ArticleEdit from './components/ArticleEdit.vue'
import { ArtGetListService, artDelService } from '@/api/article.js'
import { formatTime } from '@/utils/format.js'
const articleList = ref([]) // 文章列表
const total = ref(0) //文章列表
const loading = ref(false)

// 删除逻辑
const onDeleteArticle = async (row) => {
  await ElMessageBox.confirm('你确认删除该文章信息吗？', '温馨提示', {
    type: 'warning',
    confirmButtonText: '确认',
    cancelButtonText: '取消'
  })
  await artDelService(row.id)
  ElMessage({ type: 'success', message: '删除成功' })
  getArticleList()
}

// 定义请求参数对象
const params = ref({
  pagenum: 1, // 当前页数
  pagesize: 5, // 当前生效的每页条数
  cate_id: '',
  state: ''
})
// 获取文章列表数据的方法
const getArticleList = async () => {
  loading.value = true
  const res = await ArtGetListService(params.value)
  articleList.value = res.data.data
  total.value = res.data.total
  loading.value = false
}
getArticleList()
const articleEditRef = ref()
// 添加逻辑
const onAddArticle = () => {
  articleEditRef.value.open({})
}
// 编辑逻辑
const onEditArticle = (row) => {
  articleEditRef.value.open(row)
}

// 分页器的逻辑
const onSizeChange = (size) => {
  // console.log(size)
  // 当前的页数意义不大，把当前页数改成第一页，其次更新页数
  params.value.pagenum = 1
  // 更新每页条数
  params.value.pagesize = size
  // 基于最新的当前页，和每页条数去渲染页面
  getArticleList()
}
const onCurrentChange = (page) => {
  // 更新当前页
  params.value.pagenum = page
  // 基于最新当前页进行渲染
  getArticleList()
}
// 搜索逻辑
const onSearch = () => {
  params.value.pagenum = 1
  getArticleList()
}
// 重置逻辑：清空选中栏的状态，重置页数为1，重新渲染
const onReset = () => {
  params.value.pagenum = 1
  params.value.cate_id = ''
  params.value.state = ''
  getArticleList()
}

// 处理添加/编辑成功的逻辑
const onsuccess = (type) => {
  if (type === 'add') {
    // 如果是添加，渲染最后一页
    const lastPage = Math.ceil((total.value + 1) / params.value.pagesize)
    // 切换到最后一页
    params.value.pagenum = lastPage
  }
  // 如果是编辑，渲染当前页
  getArticleList()
}
</script>
<template>
  <pageContainer title="文章管理">
    <template #extra>
      <el-button type="primary" @click="onAddArticle">添加文章</el-button>
    </template>

    <!-- 表单区域 -->
    <el-form inline>
      <el-form-item label="文章分类：">
        <!-- vue2中, v-model是@input 和:value 的简写 -->
        <!-- vue3中, v-model是 @update 和 :modeValue 的简写 -->
        <channelselect v-model:cid="params.cate_id"></channelselect>
      </el-form-item>
      <!-- 后台标记h发布状态是通过中文确定 -->
      <el-form-item label="发布状态：">
        <el-select v-model="params.state">
          <el-option label="已发布" value="已发布"></el-option>
          <el-option label="草稿" value="草稿"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button @click="onSearch" type="primary">搜索</el-button>
        <el-button @click="onReset">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 表格区域 -->
    <el-table :data="articleList" v-loading="loading">
      <el-table-column label="文章标题" prop="title">
        <template #default="{ row }">
          <el-link type="primary" :underline="false">{{ row.title }}</el-link>
        </template>
      </el-table-column>
      <el-table-column label="分类" prop="cate_name"></el-table-column>
      <el-table-column label="发表时间" prop="pub_date">
        <template #default="{ row }"> {{ formatTime(row.pub_date) }} </template>
      </el-table-column>
      <el-table-column label="状态" prop="state"></el-table-column>
      <el-table-column label="操作">
        <template #default="{ row }">
          <el-button
            circle
            plain
            type="primary"
            :icon="Edit"
            @click="onEditArticle(row)"
          ></el-button>
          <el-button
            circle
            plain
            type="danger"
            :icon="Delete"
            @click="onDeleteArticle(row)"
          ></el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页器 -->
    <el-pagination
      v-model:current-page="params.pagenum"
      v-model:page-size="params.pagesize"
      :page-sizes="[2, 3, 5, 10]"
      :background="true"
      layout="jumper,total, sizes, prev, pager, next"
      :total="total"
      @size-change="onSizeChange"
      @current-change="onCurrentChange"
      style="margin: 20px 20px 0; justify-content: flex-end"
    />
    <!-- 添加抽屉组件 -->
    <ArticleEdit ref="articleEditRef" @success="onsuccess"></ArticleEdit>
  </pageContainer>
</template>
<style lang="scss" scoped></style>
