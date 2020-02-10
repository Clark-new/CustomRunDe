<template>
  <div class="panel-wrapper">
    <div class="panel-left">
      <div class="panel-info">
        <p class="panel-name" :class="{ 'panel-name--row': !subStatus }">
          {{ name }}
        </p>
        <p class="panel-number-wrap">
          <span class="panel-number">{{ number }}</span>
          <span class="panel-text">人在看</span>
        </p>
      </div>
    </div>
    <div class="panel-right">
      <div class="gift-btn-wrap" @click="handleSendGiftClick">
        <span class="gift-icon"></span>
        <span class="gift-text">送礼物</span>
      </div>
    </div>
  </div>
</template>

<script>
/**
 * 显示昵称和在线人数组件
 * */
export default {
  name: "Panel",
  props: {
    name: {
      type: String,
      default: ""
    },
    number: {
      type: Number,
      default: 0
    },
    subStatus: {
      type: Boolean,
      default: true
    }
  },
  methods: {
    handleSendGiftClick() {
      this.$emit("opengift");
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "~styles/mixins.styl"

.panel-wrapper
  height 100%
  background-color $fff
  padding-left 30px
  padding-right 30px
  box-sizing border-box
  display flex
  flex-direction row
  justify-content space-between
  align-items center
  .panel-left
    .panel-info
      display flex
      flex-wrap wrap
      align-items center
      .panel-name
        baseTextStyle(32px, $c333, $boldFontWeight, $baseFontFamily)
        width 221px
        ellipsis()
        line-height 49px
      .panel-name--row
        width auto
        margin-right 38px
        max-width 221px
      .panel-number-wrap
        line-height 49px
        .panel-number
          baseTextStyle(28px, #969494, $baseFontWeight, $baseFontFamily)
          display inline-block
          max-width 142px
          ellipsis()
          vertical-align middle
        .panel-text
          baseTextStyle(28px, #969494, $baseFontWeight, $baseFontFamily)
          vertical-align middle
  .panel-right
    float right
    .gift-btn-wrap
      margin 30px 0
      box-sizing border-box
      width 150px
      height 60px
      border 1px solid $FE992A
      border-radius 8px
      display flex
      align-items center
      .gift-icon
        bg-image('gift', 40)
        margin-left 13px
      .gift-text
        display inline-block
        baseTextStyle(28px, $FE992A, $boldFontWeight, $baseFontFamily)
        margin-left 5px
        height 100%
        line-height 60px
        vertical-align bottom
</style>
