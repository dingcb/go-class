<template>
  <div class="base-dialog-message">
    <el-dialog
      :visible.sync="show"
      width="380px"
      :showClose="false"
      :close-on-click-modal="false"
      :close-on-press-escape="false"
    >
      <div class="dialog-content">
        <div class="des">
          {{ msg }}
        </div>
        <div>
          <el-button class="end" round @click="end">{{$t('room.room_tip_determine')}}</el-button>
        </div>
      </div>
    </el-dialog>
  </div>
</template>
<script>
export default {
  name: 'RoomDialogMessage',
  props: ['msg'],
  data() {
    return {
      show: false
    }
  },
  methods: {
    end() {
      this.show = false
      this.$route.meta.reload = true
      this.$router.replace('/login')
    }
  }
}
</script>
<style lang="scss">
.base-dialog-message {
  .el-dialog {
    width: 230px !important;
    border-radius: 6px;
  }
  .el-dialog__wrapper {
    margin-top: 22vh;
  }
  .el-dialog__header {
    display: none !important;
  }
  .el-dialog__headerbtn {
    @include abs-pos(16px, 16px, auto, auto);
    font-size: 12px;
  }
  .el-dialog__body {
    padding: 0;
    padding-top: 40px;
    font-size: 12px;
  }
  .el-dialog__title {
    @include sc(14px, #18191a);
  }
  .dialog-content {
    padding: 0 0 30px 0;
  }
  .des {
    margin-bottom: 30px;
    color: #18191a;
  }
  .el-button.is-round {
    padding: 0;
    @include wh(70px, 30px);
    @include sc(12px, #ffffff);
    padding: 0;
    border: 0;
    border-radius: 15px;
  }

  .end {
    background-color: #1742f5;
    &:hover {
      background-color: #0030ff;
      color: #fff;
    }
    &:active {
      background-color: #0030ff !important;
      color: #fff;
    }
    &:focus {
      background-color: #1742f5;
      color: #fff;
    }
  }

  .cancle {
    background-color: #b1b4bd;
    &:hover {
      background-color: #a3a6ad;
      color: #fff;
    }
    &:focus {
      background-color: #a3a6ad !important;
      color: #fff;
    }
  }
}
</style>
