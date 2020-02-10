<template>
  <div class="transfer-wrapper"></div>
</template>

<script>
/**
 * 路由跳转中间组件
 * 当点击直播目录切换的时候，会出现自己跳到自己页面的情况，需要跳转到一个其他页面，然后在跳到目标页面即可。
 * */
import {log} from 'common/utils'

export default {
  name: 'Transfer',
  methods: {},
  mounted () {
    log('transfer live', this.$route)
    const name = this.$route.params.name
    const options = this.$route.params.options
    this.$router.push({
      name: name,
      params: {
        options: options
      }
    })
  }
}
</script>
