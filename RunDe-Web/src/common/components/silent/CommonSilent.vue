<template>
  <div class="silent-wrap" v-show="isShow" @click="handleSilentClick">
    <div class="silent-wrap__content-wrap">
      <div class="content-wrap__img-wrap">
        <img class="img" :src="require('images/' + tag + '.png')" alt="">
      </div>
      <div class="content-wrap__title">
        {{title}}
      </div>
      <div class="content-wrap__info">
        {{banInfo}}
      </div>
    </div>
  </div>
</template>

<script>
/**
 * 禁言组件
 * */
import HuodeScene from 'common/websdk/live'
import { log } from 'common/utils'

export default {
  name: 'CommonSilent',
  data () {
    return {
      banInfo: '讲师已开启全体禁言',
      title: '全体禁言',
      timer: 0,
      isShow: false,
      tag: 'forbidden'
    }
  },
  created () {
    this.hd = new HuodeScene()
    this.addEvents()
  },
  methods: {
    addEvents () {
      this.hd.onInformation((info) => {
        log('onInformation', info)
        this.popup(true, '全体禁言', '讲师已开启全体禁言')
      })
      this.hd.onBanChat((isBan) => {
        log('onBanChat', isBan)
        this.popup(true, '全体禁言', '讲师已开启全体禁言')
      })
      this.hd.onUnBanChat((isBan) => {
        log('onUnBanChat', isBan)
        this.popup(false, '解除全体禁言', '讲师已解除全体禁言')
      })
    },
    popup (isBan, title, banInfo) {
      this.tag = isBan ? 'forbidden' : 'relieve'
      this.title = title
      this.banInfo = banInfo
      this.isShow = true
      this.timer && clearTimeout(this.timer)
      this.timer = setTimeout(() => {
        this.isShow = false
        this.timer = 0
      }, 2000)
    },
    handleSilentClick () {
      this.timer && clearTimeout(this.timer)
      this.isShow = false
    }
  }
}
</script>

<style lang="stylus" scoped>

.silent-wrap
  position fixed
  height 100%
  width 100%
  background-color rgba(0, 0, 0, 0.5)
  z-index 3
  .silent-wrap__content-wrap
    width 214px
    height 207px
    background rgba(255,255,255,1)
    border-radius 8px
    position absolute
    top 50%
    left 50%
    margin-top -103.5px
    margin-left -107px
    .content-wrap__img-wrap
      width 61.2px
      height 61.2px
      margin 0 auto
      margin-top 25px
      .img
        width 61.2px
        height 61.2px
    .content-wrap__title
      text-align center
      width 100%
      height 25px
      font-size 26px
      font-family PingFang SC
      font-weight bold
      color rgba(51,51,51,1)
      margin 0 auto
      margin-top 22px
    .content-wrap__info
      text-align center
      width 100%
      height 21px
      font-size 21px
      font-family PingFang SC
      font-weight 500
      color rgba(153,153,153,1)
      margin 0 auto
      margin-top 23px
</style>
