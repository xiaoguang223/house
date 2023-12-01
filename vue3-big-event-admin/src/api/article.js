import request from '@/utils/request'
// 分类:获取文章分类
export const artGetChannelsService = () => {
  return request.get('/my/cate/list')
}
// 分类:添加文章分类
export const artAddChannelService = (data) => {
  return request.post('/my/cate/add', data)
}
// 分类:编辑文章分类
export const ArtEditChannelService = (data) => {
  return request.put('/my/cate/info', data)
}
// 分类:删除文章分类
export const ArtDelChannelService = (id) => {
  return request.delete('/my/cate/del', {
    params: {
      id
    }
  })
}

// 文章: 获取文章列表
export const ArtGetListService = (params) => {
  return request.get('/my/article/list', {
    params: params
  })
}

// 添加文章接口方法处理
export const artPublishService = (data) => {
  return request.post('/my/article/add', data)
}

// 获取文章详情接口封装
export const artGetDetailService = (id) => {
  return request.get('/my/article/info', {
    params: {
      id
    }
  })
}
// 文章：编辑文章接口
export const artEditService = (data) => {
  return request.put('/my/article/info', data)
}

// 文章： 删除文章的接口
export const artDelService = (id) => {
  return request.delete('my/article/info', { params: { id } })
}
