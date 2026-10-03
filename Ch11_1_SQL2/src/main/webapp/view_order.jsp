<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="tw.com.web.Product" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>美食點餐系統</title>

<style>

* {
    box-sizing: border-box;
}

body {
    margin: 0;
    font-family: "Microsoft JhengHei", Arial, sans-serif;
    background-color: #fff7ed;
    color: #333;
}


/* =========================
   上方標題
   ========================= */

.header {
    background: linear-gradient(135deg, #e63946, #c1121f);
    color: white;

    padding: 22px 40px;

    display: flex;
    justify-content: space-between;
    align-items: center;

    box-shadow: 0 4px 12px rgba(0,0,0,0.18);
}

.logo {
    font-size: 30px;
    font-weight: bold;
}

.header-text {
    font-size: 17px;
}


/* =========================
   主內容
   ========================= */

.container {
    width: 90%;
    max-width: 1200px;

    margin: 40px auto;
}

.title {
    text-align: center;

    font-size: 34px;

    color: #b91c1c;

    margin-bottom: 8px;
}

.subtitle {
    text-align: center;

    color: #777;

    margin-bottom: 35px;
}


/* =========================
   商品區
   ========================= */

.product-list {

    display: grid;

    /*
       自動排列商品
       畫面大時一排多個
       畫面小時自動換行
    */
    grid-template-columns:
        repeat(auto-fit, minmax(250px, 1fr));

    gap: 25px;
}


/* =========================
   商品卡片
   ========================= */

.product-card {

    background-color: white;

    border-radius: 18px;

    padding: 25px;

    box-shadow:
        0 5px 18px rgba(0,0,0,0.10);

    transition: 0.3s;

    border-top: 6px solid #f59e0b;
}


/* 滑鼠移過去 */

.product-card:hover {

    transform: translateY(-8px);

    box-shadow:
        0 12px 28px rgba(0,0,0,0.18);
}


/* 食物圖 */

.food-icon {

    text-align: center;

    font-size: 75px;

    margin-bottom: 15px;
}


/* 商品名稱 */

.product-name {

    font-size: 23px;

    font-weight: bold;

    text-align: center;

    margin-bottom: 20px;
}


/* 商品資料 */

.product-info {

    border-top: 1px solid #eeeeee;

    padding-top: 15px;
}


/* 每一行 */

.info-row {

    display: flex;

    justify-content: space-between;

    align-items: center;

    margin: 12px 0;

    font-size: 17px;
}


/* 價格 */

.price {

    color: #dc2626;

    font-size: 24px;

    font-weight: bold;
}


/* 庫存 */

.stock {

    background-color: #dcfce7;

    color: #15803d;

    padding: 5px 10px;

    border-radius: 20px;

    font-weight: bold;
}


/* =========================
   點餐區
   ========================= */

.order-area {

    margin-top: 20px;

    display: flex;

    gap: 10px;
}


.count {

    width: 70px;

    padding: 10px;

    border: 1px solid #ddd;

    border-radius: 8px;

    font-size: 16px;

    text-align: center;
}


.order-button {

    flex: 1;

    border: none;

    background-color: #f59e0b;

    color: white;

    font-size: 17px;

    font-weight: bold;

    border-radius: 8px;

    cursor: pointer;

    padding: 12px;
}


.order-button:hover {

    background-color: #d97706;
}


/* =========================
   沒商品
   ========================= */

.empty {

    background-color: white;

    padding: 50px;

    text-align: center;

    border-radius: 15px;

    font-size: 20px;

    color: #777;

    box-shadow:
        0 5px 18px rgba(0,0,0,0.10);
}


/* =========================
   Footer
   ========================= */

.footer {

    margin-top: 60px;

    padding: 30px;

    background-color: #7f1d1d;

    color: white;

    text-align: center;
}

</style>

</head>

<body>


<!-- =========================
     網頁標題
     ========================= -->

<div class="header">

    <div class="logo">
        🍔 美味點餐
    </div>

    <div class="header-text">
        現點現做・美味上桌
    </div>

</div>



<div class="container">


    <h1 class="title">
        今日美食菜單
    </h1>

    <div class="subtitle">
        選擇喜歡的餐點
    </div>



<%

    /*
     * 從 Servlet 取得商品資料
     */

    ArrayList<Product> resultList =
        (ArrayList<Product>)
        request.getAttribute("resultList");


    /*
     * 先檢查是否有資料
     */

    if(resultList != null &&
       resultList.size() > 0){

%>


<div class="product-list">


<%

    /*
     * 一筆 Product
     * 產生一張商品卡片
     */

    for(Product v : resultList){


        /*
         * 取得商品名稱
         */

        String productName =
            v.name();


        /*
         * 預設圖片
         */

        String icon = "🍽️";


        /*
         * =========================
         * 根據商品名稱判斷圖片
         * =========================
         */


        /*
         * 薯條
         */

        if(productName.contains("薯條")){

            icon = "🍟";
        }


        /*
         * 雞塊
         */

        else if(productName.contains("雞塊")){

            icon = "🍗";
        }


        /*
         * 可樂 / 飲料
         */

        else if(
            productName.contains("可樂") ||
            productName.contains("飲料")
        ){

            icon = "🥤";
        }


        /*
         * 魚
         *
         * 注意：
         * 要放在「漢堡」判斷前面。
         *
         * 因為：
         * 香魚堡
         *
         * 同時也有「堡」。
         */

        else if(
            productName.contains("魚") ||
            productName.contains("香魚")
        ){

            icon = "🐟";
        }


        /*
         * Apple / 蘋果
         */

        else if(
            productName.toLowerCase().contains("apple") ||
            productName.contains("蘋果")
        ){

            icon = "🍎";
        }


        /*
         * 漢堡
         *
         * 例如：
         *
         * 1號漢堡
         * 4號豬肉漢堡
         * 原味牛肉堡
         */

        else if(
            productName.contains("漢堡") ||
            productName.contains("牛肉堡") ||
            productName.contains("豬肉堡") ||
            productName.contains("堡")
        ){

            icon = "🍔";
        }

%>



<!-- =========================
     單一商品
     ========================= -->

<div class="product-card">


    <!-- 商品圖片 -->

    <div class="food-icon">

        <%= icon %>

    </div>



    <!-- 商品名稱 -->

    <div class="product-name">

        <%= v.name() %>

    </div>



    <!-- 商品資料 -->

    <div class="product-info">


        <!-- 價格 -->

        <div class="info-row">

            <span>
                售價
            </span>

            <span class="price">

                NT$ <%= v.price() %>

            </span>

        </div>



        <!-- 庫存 -->

        <div class="info-row">

            <span>
                剩餘數量
            </span>

            <span class="stock">

                <%= v.stock() %> 份

            </span>

        </div>


    </div>



    <!-- 點餐 -->

    <div class="order-area">

        <input
            class="count"
            type="number"
            value="1"
            min="1"
            max="<%= v.stock() %>"
        >


        <button
            class="order-button"
            type="button">

            🛒 加入訂單

        </button>

    </div>


</div>


<%

    }   // for 結束

%>


</div>


<%

    }else{

%>


<!-- 沒有商品資料 -->

<div class="empty">

    <div style="font-size:70px;">
        🍽️
    </div>

    <h2>
        目前沒有餐點
    </h2>

    <p>
        請稍後再來看看
    </p>

</div>


<%

    }

%>


</div>



<!-- =========================
     Footer
     ========================= -->

<div class="footer">

    🍔 美味點餐系統

    <br><br>

    美味・快速・現點現做

</div>


</body>
</html>