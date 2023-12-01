<script setup>
import { ref } from 'vue'
import { artGetChannelsService, ArtDelChannelService } from '../../api/article'
import { Edit, Delete } from '@element-plus/icons-vue'
import ChannelEdit from './components/ChannelEdit.vue'
import { ElMessage } from 'element-plus'
const channelList = ref([])

const loading = ref(false)
// 组件数据
const dialog = ref()

const getChannelList = async () => {
  loading.value = true
  const res = await artGetChannelsService()
  channelList.value = res.data.data
  console.log(channelList.value)
  loading.value = false
}
getChannelList()

// 编辑
const onExitChannel = (row) => {
  dialog.value.open(row)
}
// 删除
const onDelChannel = async (row) => {
  // 弹出确认框提示
  await ElMessageBox.confirm('你确认要删除该分类吗？', '温馨提示', {
    type: 'warning',
    confirmButtonText: '确认',
    cancelButtonText: '取消'
  })
  await ArtDelChannelService(row.id)
  // 删除成功提示和重新渲染
  ElMessage.success('删除成功')
  getChannelList()
}
// 添加分类
const onAddChannel = () => {
  dialog.value.open({})
}
// 响应子组件的自定义事件
const onSuccess = () => {
  // 重新渲染
  getChannelList()
}
</script>
<template>
  <pageContainer title="文章分类">
    <template #extra>
      <el-button @click="onAddChannel" type="primary">添加分类</el-button>
    </template>
    <el-table v-loading="loading" :data="channelList" style="width: 100%">
      <el-table-column type="index" label="序号" width="100"></el-table-column>
      <el-table-column prop="cate_name" label="分类名称"></el-table-column>
      <el-table-column prop="cate_alias" label="分类别名"></el-table-column>
      <el-table-column label="操作" width="150">
        <template #default="{ row, $index }">
          <el-button
            :icon="Edit"
            circle
            plain
            type="primary"
            @click="onExitChannel(row, $index)"
          ></el-button>
          <el-button
            :icon="Delete"
            circle
            plain
            type="danger"
            @click="onDelChannel(row, $index)"
          ></el-button>
        </template>
      </el-table-column>

      <template #empty>
        <el-empty description="没有数据"></el-empty>
      </template>
    </el-table>
    <ChannelEdit ref="dialog" @success="onSuccess"></ChannelEdit>
  </pageContainer>
</template>
<style lang="scss" scoped></style>
