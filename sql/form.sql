/*
 Navicat Premium Data Transfer

 Source Server         : localhost_27017
 Source Server Type    : MongoDB
 Source Server Version : 50005
 Source Host           : localhost:27017
 Source Schema         : form

 Target Server Type    : MongoDB
 Target Server Version : 50005
 File Encoding         : 65001

 Date: 10/12/2023 16:35:53
*/


// ----------------------------
// Collection structure for aaaa
// ----------------------------
db.getCollection("aaaa").drop();
db.createCollection("aaaa");

// ----------------------------
// Documents of aaaa
// ----------------------------

// ----------------------------
// Collection structure for template
// ----------------------------
db.getCollection("template").drop();
db.createCollection("template");

// ----------------------------
// Documents of template
// ----------------------------
db.getCollection("template").insert([ {
    _id: ObjectId("6557823884d6c745fe407821"),
    templateName: "test",
    createTime: ISODate("2023-11-17T15:09:44.314Z"),
    updateTime: ISODate("2023-11-23T06:51:40.97Z"),
    delete: NumberInt("0"),
    _class: "com.formSysytem.entity.Template",
    jsonData: [
        {
            id: NumberInt("0"),
            fieldName: "字段1",
            fieldType: "文本",
            required: "是",
            AAA: "AAA",
            "LAY_NUM": NumberInt("1"),
            "LAY_INDEX": NumberInt("0")
        },
        {
            id: NumberInt("1"),
            fieldName: "字段2",
            fieldType: "文本",
            required: "是",
            "LAY_NUM": NumberInt("2"),
            "LAY_INDEX": NumberInt("1")
        },
        {
            id: NumberInt("2"),
            fieldName: "字段3",
            fieldType: "文本",
            required: "否",
            "LAY_NUM": NumberInt("3"),
            "LAY_INDEX": NumberInt("2")
        },
        {
            id: NumberInt("3"),
            fieldName: "字段4",
            fieldType: "邮箱",
            required: "否",
            "LAY_NUM": NumberInt("4"),
            "LAY_INDEX": NumberInt("3")
        },
        {
            id: NumberInt("4"),
            fieldName: "111",
            fieldType: "只能输入数字",
            required: "否",
            "LAY_NUM": NumberInt("5"),
            "LAY_INDEX": NumberInt("4")
        },
        {
            id: NumberInt("5"),
            fieldName: "123",
            fieldType: "日期",
            required: "否",
            "LAY_NUM": NumberInt("6"),
            "LAY_INDEX": NumberInt("5")
        }
    ]
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("655c1ee0c63b2264eb687d48"),
    templateName: "test2",
    createTime: ISODate("2023-11-21T03:07:12.486Z"),
    updateTime: ISODate("2023-11-21T03:07:12.486Z"),
    delete: NumberInt("0"),
    _class: "com.formSysytem.entity.Template"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("655e09c10717fd38203e41cd"),
    templateName: "aaaa",
    createTime: ISODate("2023-11-22T14:01:37.065Z"),
    updateTime: ISODate("2023-11-22T14:01:37.065Z"),
    delete: NumberInt("0"),
    _class: "com.formSysytem.entity.Template"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("6572df436d239d13a7b5be56"),
    templateName: "test模板",
    createTime: ISODate("2023-12-08T09:17:55.972Z"),
    updateTime: ISODate("2023-12-08T09:17:55.972Z"),
    delete: NumberInt("0"),
    _class: "com.formSysytem.entity.Template"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("6572df4a6d239d13a7b5be57"),
    templateName: "test3模板",
    createTime: ISODate("2023-12-08T09:18:02.397Z"),
    updateTime: ISODate("2023-12-08T09:18:02.397Z"),
    delete: NumberInt("0"),
    _class: "com.formSysytem.entity.Template"
} ]);

// ----------------------------
// Collection structure for test
// ----------------------------
db.getCollection("test").drop();
db.createCollection("test");

// ----------------------------
// Documents of test
// ----------------------------
db.getCollection("test").insert([ {
    _id: ObjectId("657127d9de42404b34b04526"),
    "字段1": "aa",
    "字段2": "aa",
    "字段3": "aa",
    "字段4": "aa",
    111: "2",
    123: "2023-12-09T15:37"
} ]);
db.getCollection("test").insert([ {
    _id: ObjectId("65714c5b5cd3e5683fcb57d5"),
    "字段1": "aa",
    "字段2": "aa",
    "字段3": "aa",
    "字段4": "aa1",
    111: "",
    123: "2023-12-09T15:31"
} ]);
db.getCollection("test").insert([ {
    _id: ObjectId("65714c825cd3e5683fcb57d6"),
    "字段1": "aa",
    "字段2": "aa",
    "字段3": "aa",
    "字段4": "aa12"
} ]);
db.getCollection("test").insert([ {
    _id: ObjectId("65714d825cd3e5683fcb57d7"),
    "字段1": "aa",
    "字段2": "aa",
    "字段3": "aa",
    "字段4": "aa1"
} ]);
db.getCollection("test").insert([ {
    _id: ObjectId("6572def76d239d13a7b5be4e"),
    111: "",
    123: "",
    "字段1": "11",
    "字段2": "11",
    "字段3": "",
    "字段4": ""
} ]);
db.getCollection("test").insert([ {
    _id: ObjectId("6572defb6d239d13a7b5be4f"),
    111: "",
    123: "",
    "字段1": "11",
    "字段2": "11",
    "字段3": "",
    "字段4": ""
} ]);
db.getCollection("test").insert([ {
    _id: ObjectId("6572df036d239d13a7b5be50"),
    111: "",
    123: "",
    "字段1": "11",
    "字段2": "11",
    "字段3": "",
    "字段4": ""
} ]);
db.getCollection("test").insert([ {
    _id: ObjectId("6572df126d239d13a7b5be51"),
    111: "",
    123: "",
    "字段1": "11",
    "字段2": "11",
    "字段3": "",
    "字段4": ""
} ]);
db.getCollection("test").insert([ {
    _id: ObjectId("6572df166d239d13a7b5be52"),
    111: "",
    123: "",
    "字段1": "11",
    "字段2": "11",
    "字段3": "",
    "字段4": ""
} ]);
db.getCollection("test").insert([ {
    _id: ObjectId("6572df1a6d239d13a7b5be53"),
    111: "",
    123: "",
    "字段1": "11",
    "字段2": "11",
    "字段3": "",
    "字段4": ""
} ]);
db.getCollection("test").insert([ {
    _id: ObjectId("6572df1e6d239d13a7b5be54"),
    111: "",
    123: "",
    "字段1": "11",
    "字段2": "11",
    "字段3": "",
    "字段4": ""
} ]);
db.getCollection("test").insert([ {
    _id: ObjectId("6572df276d239d13a7b5be55"),
    111: "",
    123: "",
    "字段1": "11",
    "字段2": "11",
    "字段3": "",
    "字段4": ""
} ]);
db.getCollection("test").insert([ {
    _id: ObjectId("657337164b0417534709d7a9"),
    111: "10",
    123: "2003-12-11T01:01",
    "字段1": "11",
    "字段2": "11",
    "字段3": "",
    "字段4": "15811739638@qq.com"
} ]);
db.getCollection("test").insert([ {
    _id: ObjectId("657337a24b0417534709d7aa"),
    111: "",
    123: "0012-11-11T11:11",
    "字段1": "11",
    "字段2": "11",
    "字段3": "",
    "字段4": ""
} ]);

// ----------------------------
// Collection structure for test2
// ----------------------------
db.getCollection("test2").drop();
db.createCollection("test2");

// ----------------------------
// Documents of test2
// ----------------------------

// ----------------------------
// Collection structure for test3模板
// ----------------------------
db.getCollection("test3模板").drop();
db.createCollection("test3模板");

// ----------------------------
// Documents of test3模板
// ----------------------------

// ----------------------------
// Collection structure for test模板
// ----------------------------
db.getCollection("test模板").drop();
db.createCollection("test模板");

// ----------------------------
// Documents of test模板
// ----------------------------
