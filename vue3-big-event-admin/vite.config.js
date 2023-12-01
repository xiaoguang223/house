import { fileURLToPath, URL } from 'node:url'
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'

export default defineConfig({
  // devServer: {
  //   proxy: {
  //     '/ahouselist': {
  //       target: 'http://localhost:8080',
  //       changeOrigin: true,
  //       rewrite: (path) => path.replace(/^\/ahouselist/, '')
  //     }
  //   }
  // },
  // devServer: {
  //   proxy: {
  //     '/api': {
  //       target: 'http://localhost:8080', // server地址
  //       changeOrigin: true, // 允许跨域
  //       pathRewrite: {
  //         '^/api': ''
  //       }
  //     }
  //   }
  // },
  plugins: [
    vue(),
    AutoImport({
      resolvers: [ElementPlusResolver()]
    }),
    Components({
      resolvers: [ElementPlusResolver()]
    })
  ],
  base: '/',
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }
})
