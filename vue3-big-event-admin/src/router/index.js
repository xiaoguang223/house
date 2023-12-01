/*
 * @Author: 暮秋pro oncwnuDcKAa9aHtUN1_rnIGw84kY@git.weixin.qq.com
 * @Date: 2023-11-20 14:58:04
 * @LastEditors: 暮秋pro oncwnuDcKAa9aHtUN1_rnIGw84kY@git.weixin.qq.com
 * @LastEditTime: 2023-11-21 12:36:33
 * @FilePath: \vue3-big-event-admin\src\router\index.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import { createRouter, createWebHistory } from 'vue-router'
import { useUserStore } from '@/stores'

// createRouter: 创建路由示例
// 1.配置 history
// 2.hash模式：createWebHashHistory
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/login', component: () => import('@/views/login/LoginPage.vue') }, // 登录页
    {
      path: '/',
      component: () => import('@/views/layout/LayoutContainer.vue'),
      redirect: '/Property',
      children: [
        {
          path: '/article/manage',
          component: () => import('@/views/article/ArticleManage.vue')
        },
        {
          path: '/article/channel',
          component: () => import('@/views/article/ArticleChannel.vue')
        },
        {
          path: '/user/profile',
          component: () => import('@/views/user/UserProfile.vue')
        },
        {
          path: '/user/avatar',
          component: () => import('@/views/user/UserAvatar.vue')
        },
        {
          path: '/user/password',
          component: () => import('@/views/user/UserPassword.vue')
        },
        {
          path: '/Property',
          component: () => import('@/views/PropertyInfo/PropertyInfo.vue')
        },
        {
          path: '/LeaseContract/renting',
          component: () => import('@/views/LeaseContract/theRenting.vue')
        },
        {
          path: '/LeaseContract/rentingOut',
          component: () => import('@/views/LeaseContract/rentingOut.vue')
        }
      ]
    }
  ]
})

// 配置路由前置守卫
router.beforeEach((to) => {
  const useStore = useUserStore()
  // 如果没有token，还要访问非授权页面，就拦截
  if (!useStore.token && to.path !== '/login') {
    return '/login'
  }
  return true
})
export default router
