<template>
  <!-- <div>这里是退租列表</div> -->
  <BaseDataList
    title="在租列表"
    msg="这里是操作提示"
    ref="baseDataListRef"
    :table-column-attribute="sendData.tableColumnAttribute"
    :table-data="sendData.tableData"
    :page-sizes="sendData.pageSizes"
    :total="sendData.total"
    :useDropdownMenu="false"
    :handleDelete="handleDelete"
    @updateTableData="handleSizeChange"
  >
    <template #ico>
      <el-icon>
        <Notebook />
      </el-icon>
    </template>
    <template #menu>
      <div class="meau">
        <el-button @click="handelAddFn">
          <el-icon type="success" circle>
            <el-icon> <Plus /> </el-icon
          ></el-icon>
          添加
        </el-button>
        <div class="search">
          <el-input
            placeholder="请输入关键字搜索"
            v-model="searchKey"
          ></el-input>
          <el-button type="primary" :icon="Search" @click="handelSearch"
            >搜索</el-button
          >
        </div>
      </div>
    </template>
  </BaseDataList>
  <!-- 删除确认消息提示框 -->
  <el-dialog v-model="isDelete" title="温馨提示" width="30%">
    <span>你确认要删除吗?</span>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="isDelete = false">取消</el-button>
        <el-button type="primary" @click="handelDelete"> 确认 </el-button>
      </span>
    </template>
  </el-dialog>
  <!-- 添加业务=> 抽屉 -->
  <el-drawer
    size="45%"
    v-model="addDrawer"
    title="添加用户"
    direction="rtl"
    open-delay="100"
  >
    <div class="demo-drawer__content">
      <el-form
        ref="theAddForm"
        :model="addForm"
        label-width="120px"
        :rules="formRule"
      >
        <el-form-item label="申请人" :label-width="labelWidth" prop="applicant">
          <el-input v-model="addForm.applicant" autocomplete="off" />
        </el-form-item>
        <el-form-item
          label="身份证号"
          :label-width="labelWidth"
          prop="applicantId"
        >
          <el-input v-model="addForm.applicantId" autocomplete="off" />
        </el-form-item>
        <el-form-item label="联系电话" :label-width="labelWidth" prop="phone">
          <el-input v-model="addForm.phone" autocomplete="off" />
        </el-form-item>
        <el-form-item label="房屋编号" :label-width="labelWidth" prop="address">
          <el-input v-model="addForm.houseNum" autocomplete="off" />
        </el-form-item>
        <el-form-item label="地址" :label-width="labelWidth" prop="address">
          <el-input v-model="addForm.address" autocomplete="off" />
        </el-form-item>
        <el-form-item label="状态" :label-width="labelWidth">
          <el-radio-group v-model="addForm.state">
            <el-radio label="未租" />
            <el-radio label="已租" />
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div class="drawerFooter">
        <el-button @click="addDrawer = false">取消</el-button>
        <el-button type="primary" :loading="btnLoading" @click="handelAddSubmit"
          >提交</el-button
        >
      </div>
    </div>
  </el-drawer>
</template>

<script setup>
import { ref } from 'vue'
import { Search, Plus, Notebook } from '@element-plus/icons-vue'
import BaseDataList from '../../components/DataList/BaseDataList.vue'
// import { ElMessage } from 'element-plus'

// 表格数据传递
const sendData = ref({
  tableColumnAttribute: [
    {
      prop: 'applicant',
      label: '申请人',
      sortable: false
    },
    {
      prop: 'applicantId',
      label: '申请人身份证号',
      sortable: true
    },
    {
      prop: 'phone',
      label: '联系电话',
      sortable: true
    },
    {
      prop: 'houseNum',
      label: '房屋编号'
    },
    {
      prop: 'address',
      label: '地址'
    },
    {
      prop: 'state',
      label: '状态',
      useTag: true
    }
  ],
  tableData: [
    {
      applicant: '小王同学',
      applicantId: '21365347326623123',
      phone: '18663746534',
      houseNum: '263745',
      address: '王府井大街',
      state: { value: '已租', tagType: 'success' }
    },
    {
      applicant: '小李同学',
      applicantId: '411365347326623123',
      phone: '1643746534',
      houseNum: '263746',
      address: '北京四合院',
      state: { value: '已租', tagType: 'success' }
    },
    {
      applicant: '小赵同学',
      applicantId: '411365347326623123',
      phone: '17463746534',
      houseNum: '263747',
      address: '上海汤臣一品',
      state: { value: '已租', tagType: 'success' }
    },
    {
      applicant: '篮球🏀',
      applicantId: '和',
      phone: '只因🐓',
      houseNum: '坤坤背带裤',
      address: '鸡窝',
      state: { value: '已租', tagType: 'success' }
    }
  ],
  handleEdit: (row) => {
    console.log('编辑', row)
  },
  // 分页数组
  pageSizes: [5, 10, 15],
  total: 100
})

/**
 * 搜索业务
 */
// 输入框绑定的数据
const searchKey = ref('')
// 搜索方法
const handelSearch = async () => {
  if (searchKey.value === '') {
    ElMessage('搜索关键词不能为空')
    return false
  }
  // 根据编号或地址进行搜索
  const newArr = sendData.value.tableData.filter((item) => {
    if (searchKey.value === item.price) {
      return item
    }
    if (searchKey.value === item.houseNum) {
      return item
    }
    if (searchKey.value === item.address) {
      return item
    }
    if (searchKey.value === item.state.value) {
      return item
    }
  })
  baseDataListRef.value.openLoading = true
  setTimeout(() => {
    baseDataListRef.value.openLoading = false
    sendData.value.tableData = newArr
    ElMessage({
      message: '搜索成功',
      type: 'success'
    })
  }, 300)
  baseDataListRef.value.openLoading = false
  searchKey.value = ''
}

/**
 * 添加业务
 */
// 控制抽屉打开关闭的数据
const addDrawer = ref(false)
// 抽屉表单数据
const addForm = ref({
  applicant: '',
  applicantId: '',
  phone: '',
  houseNum: '',
  address: '',
  state: ''
})
// 点击添加打开抽屉, 置空数据
const handelAddFn = () => {
  // 置空表单数据
  let obj = addForm.value
  for (let key in obj) {
    obj[key] = ''
  }
  addDrawer.value = true
}

// 表单校验规则
const formRule = ref({
  // 房屋编号
  houseNum: [
    { required: true, message: '请输入房屋编号', trigger: 'blur' },
    {
      pattern: /^\d{4,10}$/,
      message: '编号必须是4-10位的数字',
      trigger: 'blur'
    }
  ],
  //地址
  address: [
    { required: true, message: '请输入地址', trigger: 'blur' },
    // { min: 1, max: 10, message: '地址必须是1-10位的字符', trigger: 'blur' }
    {
      pattern: /^(?![0-9]{1,10}$)[\u4e00-\u9fa5a-zA-Z0-9-]{1,10}$/,
      message: '请输入正确的地址格式',
      trigger: 'blur'
    }
  ],
  // 手机
  phone: [
    { required: true, message: '请输入手机号码', trigger: 'blur' },
    {
      pattern: /^1[3-9]\d{9}$/,
      message: '请输入正确的电话格式',
      trigger: 'blur'
    }
  ],
  // 申请人
  applicant: [
    { required: true, message: '请输入申请人', trigger: 'blur' },
    { min: 1, max: 10, message: '申请人必须是1-10位的字符', trigger: 'blur' }
  ],
  // 身份证号
  applicantId: [
    { required: true, message: '请输入身份证号', trigger: 'blur' },
    {
      pattern: /^\d{17}[\dXx]$|^\d{15}$/,
      message: '请输入正确的身份证号格式',
      trigger: 'blur'
    }
  ],
  // price
  price: [
    { required: true, message: '请输入价格', trigger: 'blur' },
    {
      pattern: /^\d{1,10}$/,
      message: '价格只能是1-10位的数字',
      trigger: 'blur'
    }
  ]
})
// 表单元素宽度
const labelWidth = ref('100')

// 添加表单
const theAddForm = ref('')
// 按钮提交加载的数据和方法
const btnLoading = ref(false)
const handelAddSubmit = async () => {
  // 添加表单的校验,通过了才能发送添加请求
  await theAddForm.value.validate()
  //判断选择框全部选中
  if (addForm.value.state === '') {
    ElMessage('请选择状态')
    return false
  }
  console.log('添加表单数据', addForm.value)
  btnLoading.value = true
  // 这里要处理添加接口的逻辑
  setTimeout(() => {
    let newObj = {
      tagType: '',
      value: ''
    }
    // 矫正添加数据
    let obj = addForm.value
    for (let key in obj) {
      if (key === 'state') {
        if (obj[key] === '已租') {
          newObj.value = obj[key]
          newObj.tagType = 'success'
        } else {
          newObj.value = obj[key]
          newObj.tagType = 'warning'
        }
      }
    }
    addForm.value.state = newObj
    // 渲染表格数据
    sendData.value.tableData.push(addForm.value)

    ElMessage({
      message: '添加成功',
      type: 'success'
    })
  }, 800)
  btnLoading.value = false
  addDrawer.value = false
}

/**
 * 删除业务
 */
const isDelete = ref(false)
// 删除的请求参数
const deleteParams = ref('')
const handelDelete = () => {
  isDelete.value = false
  console.log(deleteParams.value)
  const newArr = sendData.value.tableData.filter((item) => {
    if (item.houseNum !== deleteParams.value.houseNum) {
      return item
    }
  })
  console.log(newArr)
  sendData.value.tableData = newArr
  // 提示用户删除成功
  ElMessage({
    message: '删除成功',
    type: 'success'
  })
}
// 删除的业务
const handleDelete = (row) => {
  console.log(row, '删除业务')
  deleteParams.value = row
  isDelete.value = true
}

/**
 * 分页器逻辑
 */
// 子组件绑定的ref数据
const baseDataListRef = ref('')
// 获取分页数据
const $page = ref()
setTimeout(() => {
  $page.value = baseDataListRef.value.paginationData
  console.log('当前分页器数据', $page.value)
})
// 节流处理
const isPass = ref(true)
// 分页器页面数据容量改变函数
const handleSizeChange = async (pagesize, currentPage) => {
  // 节流阀为true，就发请求
  if (isPass.value === true) {
    // 关闭阀门
    isPass.value = false
    // 开启表格加载效果
    baseDataListRef.value.openLoading = true
    setTimeout(() => {
      console.log('条数:', pagesize, '当前页', currentPage)
      baseDataListRef.value.openLoading = false
      ElMessage({
        message: '刷新成功',
        type: 'success'
      })
      // 开启阀门
      isPass.value = true
    }, 800)
  } else {
    ElMessage({
      message: '请求频率过高,不予处理',
      type: 'warning'
    })
  }
}
</script>

<style lang="scss" scoped>
.tree-card {
  min-width: 200px;
  min-height: 500px;
  width: 300px;
  height: 600px;
  margin-right: 50px;
}

.card-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

// 表格菜单头样式
.meau {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}

.search {
  display: flex;
}

// 抽屉底部按钮样式
.drawerFooter {
  // width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
}

.drawerFooter button {
  margin: 0 40px;
}
</style>
