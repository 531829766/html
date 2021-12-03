// pages/mine/mine.js
Page({
  toIndex: function() {
		var t = "/pages/login/login";
		//跳转非tab页
		wx.navigateTo({
			url: t,
			fail: function() {
				//跳转tab页
				wx.switchTab({
					url: t
				});
			}
		});
  },
  data: {
     userinfo:{}
  },

  onShow(){
    const userinfo=wx.getStorageSync("userinfo");
    this.setData({userinfo})
  }
})