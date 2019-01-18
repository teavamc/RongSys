package com.ruoyi.village.util;

import com.ruoyi.village.domain.SocialCircle;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: lyb_RongSys
 * @description: 过滤文本工具 和 快速排序
 * @author: Mr.Liu
 * @create: 2019-01-17 10:50
 **/
public class FilterText {

    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
    private static final String regEx_space = "\\s*|\t|\r|\n";// 定义空格回车换行符
    private static final String regEx_w = "<w[^>]*?>[\\s\\S]*?<\\/w[^>]*?>";//定义所有w标签

    /* @param htmlStr
     * @return 删除Html标签
     * @author LongJin
     */
    public static String delHTMLTag(String htmlStr) {
        Pattern p_w = Pattern.compile(regEx_w, Pattern.CASE_INSENSITIVE);
        Matcher m_w = p_w.matcher(htmlStr);
        htmlStr = m_w.replaceAll(""); // 过滤script标签

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
        htmlStr = htmlStr.replaceAll(" ", ""); //过滤
        return htmlStr.trim(); // 返回文本字符串
    }

    /**快速排序*/
    public static List<SocialCircle> quickSort(List<SocialCircle> list, int left, int right) {
        if (left < right) {
            int plot = left;
            int index = plot +1;
            for(int i = index;i<=right;i++){
                if(list.get(i).getPcsennum() > list.get(plot).getPcsennum()){
                    swap(list,index,i);
                    index++;
                }
            }
            swap(list,plot,index-1);
            int plots = index-1;
            quickSort(list,left,plots-1);
            quickSort(list,plots+1,right);
        }
        return list;
    }
    /**交换两个值*/
    public static void swap(List<?> list , int i , int j){
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
    }
}
