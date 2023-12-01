import request from '@/utils/request'
// 获取房源信息列表的方法 + 搜索模块
export const getPropertyList = async () => {
  return request.get('/ahouselist')
}
