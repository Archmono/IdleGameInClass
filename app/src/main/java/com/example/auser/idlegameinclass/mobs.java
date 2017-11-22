package com.example.auser.idlegameinclass;

/**
 * Created by auser on 2017/11/20.
 */

public class mobs {

    int _id;
    String[] name;
    int healthPoint;                //需要點擊次數
    int actionBarTime;              //動作條時間,毫秒
    int guardPoint;                 //破防需要次數
    int elementTypes;               //題目屬性種類
    int elementQuestionRange;       //題目難度,屬性球數量3-6
    int[] weakPoint;                //弱點屬性(火1,水2,木3,光4,暗5,心6)
    int stunDuration;               //暈眩時間,毫秒
    double differenceRange;         //個體差異程度,正負 min(基礎值*(1-差異度)) max(基礎*(1+差異度))
    int weakPointEffect;            //弱點屬性對於暈眩時間增加幅度,毫秒
    double damage;                  //對玩家傷害
    int imgId;                      //圖片資源

}
