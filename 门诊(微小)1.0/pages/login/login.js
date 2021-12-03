// pages/login/login.js
Page({
	handleGetUserInfo(e){
		//console.log(e);
		const {userInfo}=e.detail;
		wx.setStorageSync('userinfo', userInfo);
		wx.switchTab({
			url:"/pages/index/index"
		});
	}
})
