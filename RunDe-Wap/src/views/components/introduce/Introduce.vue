<template>
  <div class="introduce-wrapper">
    <div class="introduce-container">
      简介：
    </div>
  </div>
</template>

<script>
/**
 * 简介组件
 * */
export default {
  name: "Introduce"
};
</script>

<style lang="stylus" scoped>
@import "~styles/mixins.styl"

.introduce-wrapper
  width-height-full()
  .introduce-container
    width-height-full()
    padding 30px
    box-sizing border-box
</style>
