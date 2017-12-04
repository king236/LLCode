/*
用途：检查输入字符串是否为空或者全部都是空格
输入：str 输入的字符串
返回：如果全是空返回true,否则返回false
 */
function isNull(str) {
	if (str == null || str == "") {
		return true;
	}
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	return re.test(str);
}

/*
 * 用途：检查输入字符串中是否含有空格 输入：str 输入的字符串 返回：如果全是空返回true,否则返回false
 */
function hasBlank(str) {
	var regu = " ";
	var re = new RegExp(regu);
	return re.test(str);
}

/*
 * 用途：检查输入对象的值是否符合整数格式 输入：str 输入的字符串 返回：如果通过验证返回true,否则返回false
 */
function isInteger(str) {
	var regu = /^[-]{0,1}[0-9]{1,}$/;
	return regu.test(str);
}

/*
 * 用途：检查输入手机号码是否正确 输入：str 输入的字符串 返回：如果通过验证返回true,否则返回false
 */
function isMobile(str) {
	var regu = /^[1][3,4,5,7,8][0-9]{9}$/;
	var re = new RegExp(regu);
	if (re.test(str)) {
		return true;
	} else {
		return false;
	}
}

/*
 * 用途：检查输入对象的值是否符合E-Mail格式 输入：str 输入的字符串 返回：如果通过验证返回true,否则返回false
 */
function isEmail(str) {
	var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,}$/;
	if (myReg.test(str))
		return true;
	return false;
}

/*
 * 用途：检查输入字符串是否只由汉字组成 输入：str 输入的字符串 返回：如果通过验证返回true,否则返回false
 */
function isChinaChar(str) {// 判断是否是汉字
	var regu = "^[\u4e00-\u9fa5]+$";
	regu = "^[\\u4E00-\\u9FFF]+$";
	var re = new RegExp(regu);
	if (re.test(str)) {
		return true;
	} else {
		return false;
	}
}

/*
 * 用途：检查输入字符串是否含有特殊字符，是则返回true，否则返回false
 */
function hasSpecialChar(str) {
	var regu = /[`~!@#\$%\^\&\*\(\)_\+\-<>\?:"\{\},\.\\\/;'\[\]]/im;
	if (regu.test(str)) {
		return true;
	} else {
		return false;
	}
}

/**
 * 
 * @descrition: 判断输入的参数是否是一个合格的身份证号码。这个函数对输入的参数检查时候是合格的身份证号码，其身份证有效性无法判断。检测的颗粒度可以定制。
 * @param->str : 待验证的参数
 * @return : true是合格的身份证 false为不合法的身份证
 * 
 */
function checkIdCard(num) {
	num = num.toUpperCase();

	var cityCode = {
		11 : "北京",
		12 : "天津",
		13 : "河北",
		14 : "山西",
		15 : "内蒙古",
		21 : "辽宁",
		22 : "吉林",
		23 : "黑龙江 ",
		31 : "上海",
		32 : "江苏",
		33 : "浙江",
		34 : "安徽",
		35 : "福建",
		36 : "江西",
		37 : "山东",
		41 : "河南",
		42 : "湖北 ",
		43 : "湖南",
		44 : "广东",
		45 : "广西",
		46 : "海南",
		50 : "重庆",
		51 : "四川",
		52 : "贵州",
		53 : "云南",
		54 : "西藏 ",
		61 : "陕西",
		62 : "甘肃",
		63 : "青海",
		64 : "宁夏",
		65 : "新疆",
		71 : "台湾",
		81 : "香港",
		82 : "澳门",
		91 : "国外 "
	};

	if (!cityCode[num.substr(0, 2)]) {
		// alert("地址编码错误");
		return false;
	}
	// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。
	if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))) {
		// alert('输入的身份证号长度不对，或者号码不符合规定！\n15位号码应全为数字，18位号码末位可以为数字或X。');
		return false;
	}
	// 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
	// 下面分别分析出生日期和校验位
	var len, re;
	len = num.length;
	if (len == 15) {
		re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
		var arrSplit = num.match(re);

		// 检查生日日期是否正确
		var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]);
		var bGoodDay;
		bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
		if (!bGoodDay) {
			// alert('输入的身份证号里出生日期不对！');
			return false;
		} else {
			// 将15位身份证转成18位
			// 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
			var nTemp = 0, k;
			num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
			for (k = 0; k < 17; k++) {
				nTemp += num.substr(k, 1) * arrInt[k];
			}
			num += arrCh[nTemp % 11];
			return true;
		}
	}
	if (len == 18) {
		re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
		var arrSplit = num.match(re);

		// 检查生日日期是否正确
		var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]);
		var bGoodDay;
		bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
		if (!bGoodDay) {
			// alert(dtmBirth.getYear());
			// alert(arrSplit[2]);
			// alert('输入的身份证号里出生日期不对！');
			return false;
		} else {
			// +++2015-09-22：取消检验校验码，降低严格性
			/*
			* // 检验18位身份证的校验码是否正确。
			* /// / 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			* var valnum;
			* var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
			* var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
			* var nTemp = 0, k;
			* for (k = 0; k < 17; k++) {
			*		nTemp += num.substr(k, 1) * arrInt[k];
			*	}
			*	valnum = arrCh[nTemp % 11];
			*	if (valnum != num.substr(17, 1)) {
			*		/// / alert('18位身份证的校验码不正确！应该为：' + valnum);
			*		return false;
			*	}
			*/
			return true;
		}
	}
	return false;
}
