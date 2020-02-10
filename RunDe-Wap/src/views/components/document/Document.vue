<template>
  <div class="document-wrapper">
    <div id="drawPanel"></div>
  </div>
</template>

<script>
/**
 * 文档组件
 * */
export default {
  name: "Document"
};
</script>

<style lang="stylus" scoped>
@import "~styles/mixins.styl"

.document-wrapper
  width-height-full()
  background-color $eee
</style>
