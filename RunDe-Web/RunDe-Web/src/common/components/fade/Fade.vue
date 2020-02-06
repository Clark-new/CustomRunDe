<template>
  <transition :style="'transition-duration: duration'">
    <slot></slot>
  </transition>
</template>

<script>
/**
 * 动画组件
 * */
export default {
  name: 'Fade',
  props: {
    enterDuration: {
      type: String,
      default: '.3s'
    },
    leaveDuration: {
      type: String,
      default: '.8s'
    }
  }
}
</script>

<style lang='stylus' scoped>
  .v-enter, .v-leave-to
    opacity 0
  .v-enter-active
    transition opacity .3s
  .v-leave-active
    transition opacity .8s
</style>
