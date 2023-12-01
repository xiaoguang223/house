<script setup>
import { ref } from 'vue'
import { artGetChannelsService } from '@/api/article.js'
const channelList = ref([])
const getChannelList = async () => {
  const res = await artGetChannelsService()
  channelList.value = res.data.data
}
getChannelList()

// 处理选中框选中逻辑
defineProps({
  cid: {
    type: [Number, String]
  },
  width: {
    type: String
  }
})
const emit = defineEmits(['update:cid'])
</script>

<template>
  <el-select
    :style="{ width }"
    :modelValue="cid"
    @update:modelValue="emit('update:cid', $event)"
  >
    <el-option
      v-for="channel in channelList"
      :key="channel.id"
      :label="channel.cate_name"
      :value="channel.id"
    ></el-option>
  </el-select>
</template>
