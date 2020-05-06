<template>
  <div class="tipBox">
    <div class="title">
      <i :class="iconText"></i>
      <span v-text="title"></span>
    </div>
    <div class="arrow"></div>
  </div>
</template>

<script>
export default {
  props: {
    title: {
      type: String,
      required: true
    },
    icon: {
      type: String,
      default: ""
    },
    link: {
      type: String,
      default: ""
    }
  },
  data() {
    return {
      iconText: "icon " + this.icon
    };
  }
};
</script>