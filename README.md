# Find_Sanmu
该项目主要用来通过拼音手写字母来查询三目信息

需要用到的技术有：
1、内存数据库
2、mybatis
3、nginx							**
4、easyui
5、mybatis自动生成工具				
6、首字母生成工具					**
FJ 范围外检查  	250309008-3
FS 范围外设施  	111000001a
FY 范围外药品  	1240000000000000000
FZ 范围外治疗 	 120100000
JJ 基本检查 	 	250203045-1
JS 基本设施 		111000002
JY 基本药品  		1200600000000190002
JZ 基本治疗  		460000019
PJ  	 		ybzl
TC 特殊材料  		3107010020000A-3a
TJ 特殊检查  		100010000001016
TY 特殊药品  		1200600000000270004
TZ 特殊治疗  		320100004
YY   			86978269000232

100010000001016	特殊检查
111000001a		范围外设施
111000002		基本设施

update table sanmu_all set baoxiaobili_chs = "范围外检查"   where biaoxiaobili = "FJ";
update table sanmu_all set baoxiaobili_chs = "范围外设施"   where biaoxiaobili = "FS";
update table sanmu_all set baoxiaobili_chs = "范围外药品"   where biaoxiaobili = "FY";
update table sanmu_all set baoxiaobili_chs = "范围外治疗"   where biaoxiaobili = "FZ";
update table sanmu_all set baoxiaobili_chs = "基本检查"     where biaoxiaobili = "JJ";
update table sanmu_all set baoxiaobili_chs = "基本设施"     where biaoxiaobili = "JS";
update table sanmu_all set baoxiaobili_chs = "基本药品"     where biaoxiaobili = "JY";
update table sanmu_all set baoxiaobili_chs = "基本治疗"     where biaoxiaobili = "JZ";
update table sanmu_all set baoxiaobili_chs = "特殊材料"     where biaoxiaobili = "TC";
update table sanmu_all set baoxiaobili_chs = "特殊检查"     where biaoxiaobili = "TJ";
update table sanmu_all set baoxiaobili_chs = "特殊药品"     where biaoxiaobili = "TY";
update table sanmu_all set baoxiaobili_chs = "特殊治疗"     where biaoxiaobili = "TZ";
