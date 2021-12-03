// pages/money/money.js
Page({
  onLoad: function (options) {
    var that = this
  // 判断用户是否授权登录
    wx.getSetting({
      success: function (res) {
        // 判断是否授权
        if (res.authSetting['scope.userInfo']) {
           //获取用户信息
          wx.getUserInfo({
            success: function (res) {
              //用户已经授权过，添加用户信息
              //var that = this
              //wx.setStorageSync('nickName', res.userInfo.nickName)
              //wx.setStorageSync('avatarUrl', res.userInfo.avatarUrl)
            }
          });
        }else{
          wx.showToast({
             title: '请授权登录！',
             icon: 'none',
             duration: 1500,
             success: function () {
          //定时器，未授权1.5秒后跳转授权页面
             setTimeout(function () {
             wx.reLaunch({
             url: '/pages/login/login',
                })
              }, 1500);
             }
            })
        }
      },
      fail:function(res){
        wx.showToast({
          title: '失败了',
        })
      }
    })
  }
})