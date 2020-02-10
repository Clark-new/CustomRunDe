<template>
  <div class="announcement-wrap" v-show="isShow">
    <div class="announcement-wrap__content-wrap">
      <p class="content__title">{{title}}</p>
      <p class="content__text">
        {{info}}
      </p>
      <div class="content__footer-button" @click="handleFooterButtonClick">
        {{know}}
      </div>
    </div>
  </div>
</template>

<script>
/**
 * 公告组件
 * */
import HuodeScene from 'common/websdk/live'
import { log } from 'common/utils'

export default {
  name: 'CommonAnnouncement',
  data () {
    return {
      info: '',
      isShow: false,
      title: '系统公告',
      know: '知道了'
    }
  },
  watch: {
    info (newVal) {
      log('公告', newVal)
      if (newVal) {
        this.isShow = true
      } else {
        this.isShow = false
      }
    }
  },
  created () {
    this.hd = new HuodeScene()
    this.addEvents()
  },
  methods: {
    addEvents () {
      this.hd.onAnnouncement((data) => {
        if (!data || data.action === 'remove') {
          this.info = ''
          return false
        }
        this.info = data
        this.bus.$emit('exit-fulls-screen')
      })
    },
    handleFooterButtonClick () {
      this.isShow = false
    }
  }
}
</script>

<style lang="stylus" scoped>
@import "~styles/mixins.styl"

.announcement-wrap
  position fixed
  width-height-full()
  background-color rgba(0, 0, 0, 0.5)
  z-index 6
  .announcement-wrap__content-wrap
    width 592px
    height 371px
    background-color #ffffff
    position absolute
    top 50%
    left 50%
    margin-top -204px
    margin-left -299.5px
    border-radius 8px
    .content__title
      width 150px
      height 34px
      baseTextStyle(30px, #333333, bold)
      margin 0 auto
      margin-top 49px
    .content__text
      width 498px
      height 137px
      line-height 36px
      baseTextStyle(20px, #999999)
      margin 0 auto
      margin-top 36px
      overflow auto
    .content__footer-button
      position absolute
      bottom 0
      border-top 1px #D2D3D5 solid
      height 100px
      width 100%
      line-height 100px
      text-align center
      baseTextStyle(36px, #FF454B)
</style>
