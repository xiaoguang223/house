<script setup>
import pageContainer from '@/components/pageContainer.vue'
import { ref } from 'vue'
import { useUserStore } from '@/stores'
import { userUpdateInfoService } from '@/api/user'

const formRef = ref()
// 用户信息
const {
  user: { email, id, nickname, username },
  getUser
} = useUserStore()

// 用户信息
const form = ref({
  username,
  nickname,
  id,
  email
})

const rules = {
  nickname: [
    { required: true, message: '请输入用户昵称', trigger: 'blur' },
    {
      pattern: /^\S{2,10}/,
      message: '昵称长度在 2 到 10 位非空字符',
      trigger: 'blur'
    }
  ],
  email: [
    { required: true, message: '请输入用户邮箱', trigger: 'blur' },
    { type: 'email', message: '邮箱格式不正确', trigger: 'blur' }
  ]
}

const submitForm = async () => {
  // 校验成功
  await formRef.value.validate()
  // 发送修改请求
  await userUpdateInfoService(form.value)
  // 更新用户信息
  getUser()
  // 修改成功
  ElMessage.success('修改成功')
}
</script>
<template>
  <pageContainer title="基本资料">
    <template #default>
      <el-form
        :model="form"
        :rules="rules"
        ref="formRef"
        label-width="120px"
        class="demo-form-styl"
      >
        <el-form-item label="登录名称">
          <el-input v-model="form.username" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="用户昵称" prop="nickname">
          <el-input v-model="form.nickname"></el-input>
        </el-form-item>
        <el-form-item label="用户邮箱" prop="email">
          <el-input v-model="form.email"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">提交修改</el-button>
        </el-form-item>
      </el-form>
    </template>
  </pageContainer>
</template>
<style>
.demo-form-styl {
  max-width: 400px;
  /* margin: 0 auto; */
  padding: 20px;
}

.demo-form-styl el-form-item {
  width: 100%; /* 或者使用 max-width，具体看实际情况 */
  margin-bottom: 15px; /* 调整元素之间的垂直间距，根据需要修改 */
}
</style>
