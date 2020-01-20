package com.yn.nacos.server.util;


/**
 * 字符串工具类，提供字符串公用操作函数
 * @version 1.0
 */
public class StringUtil
{

   /**
    * 字符串替换函数。
    * @param value 需要查找替换的字符串
    * @param key 被替换的值
    * @param replaceValue 替换的值
    * @return
    * @roseuid 417C9212004E
    */
   public static String replace(String value, String key, String replaceValue)
   {
      if(value != null && key != null && replaceValue != null) {
         int pos = value.indexOf(key);
         if(pos >= 0) {
            int length = value.length();
            int start = pos;
            int end = pos + key.length();

            if(length == key.length()) {
               value = replaceValue;
            } else if(end == length) {
               value = value.substring(0, start) + replaceValue;
            } else {
               value = value.substring(0, start) + replaceValue +
                   replace(value.substring(end), key, replaceValue);
            }
         }
      }
      return value;
   }

   /**
    * 判断字符串是否为空字符。
    * @param value
    * @return
    * @roseuid 417C9212006E
    */
   public static boolean isBlank(String value)
   {
      boolean ret = false;
      if(value != null && value.equals("")) {
         ret = true;
      }
      return ret;
   }

   /**
    * 判断字符串是否为null。
    * @param value
    * @return
    * @roseuid 417C9212007E
    */
   public static boolean isNull(String value)
   {
      return value == null ? true : false;
   }

   /**
    * 判断字符串是否为空字符串或者null。
    * @param value
    * @return
    * @roseuid 417C9212008D
    */
   public static boolean isNullOrBlank(String value)
   {
      return isNull(value) || isBlank(value);
   }

   /**
    * 字符串编码函数。
    * @param str
    * @param srcCode
    * @param targetCode
    * @return
    * @roseuid 417C9212009D
    */
   public static String encodeStr(String str, String srcCode, String targetCode)
   {
      try {
         if(str == null) {
            return null;
         }

         byte[] bytesStr = str.getBytes(srcCode);
         return new String(bytesStr, targetCode);
      } catch(Exception ex) {
         return str;
      }
   }

   /**
    * 字符串编码函数。
    * @param str
    * @param srcCode
    * @param targetCode
    * @return
    */
   public static String encodeStr(String str, String targetCode)
   {
      try {
         if(str == null) {
            return null;
         }

         byte[] bytesStr = str.getBytes();
         return new String(bytesStr, targetCode);
      } catch(Exception ex) {
         return str;
      }
   }


   /**
    * 把NULL字符串转换成空字符串。
    * @param str
    * @return
    * @roseuid 417C921200BB
    */
   public static String convertNullToBlank(String str)
   {
      return str == null ? "" : str;
   }

   /**
    * 从左起取字符串前n位。
    * @param str
    * @param length
    * @return
    * @roseuid 417C921200CB
    */
   public static String left(String str, int length)
   {
      if(str == null) {
         throw new IllegalArgumentException("字符串参数值不能为null");
      }
      if(length < 0) {
         throw new IllegalArgumentException("整型参数长度不能小于0");
      }
      if(str.length() < length) {
         throw new IllegalArgumentException("字符串参数长度不能小于" + length);
      }

      return str.substring(0, length);
   }

   /**
    * 从右起取字符串后n位。
    * @param str
    * @param length
    * @return
    * @roseuid 417C9212010A
    */
   public static String right(String str, int length)
   {
      if(str == null) {
         throw new IllegalArgumentException("字符串参数值不能为null");
      }
      if(length < 0) {
         throw new IllegalArgumentException("整型参数长度不能小于0");
      }
      if(str.length() < length) {
         throw new IllegalArgumentException("字符串参数长度不能小于" + length);
      }

      return str.substring(str.length() - length);
   }

   /**
    * 取指定字符串中间n位，字符串的位置从1开始算起。
    * @param str - 指定字符串。
    * @param beginIndex - 开始位置（包含）。
    * @param endIndex - 结束位置（包含）。
    * @param beginIdex
    * @return String
    * @roseuid 41D2834D001F
    */
   public static String mid(String str, int beginIdex, int endIndex)
   {
      if(str == null) {
         throw new IllegalArgumentException("字符串参数值不能为null");
      }

      return str.substring(beginIdex - 1, endIndex);
   }

   /**
    * 生成下一个顺序号。
    * @param currSerialNo - 数据库中当前最大的顺序号。
    * @param length - 顺序号的位数。
    * @return String - 下一个顺序号。
    * @roseuid 41D398FC00BB
    */
   public static String genNextSerialNo(String currSerialNo, int length)
   {
      String result = "" ;

      //如果currSerialNo不够位数，在前面加“0”。
      if (currSerialNo.length() < length){
         String zeroStr = "";
         for (int i=length-currSerialNo.length(); i>0; i--){
            zeroStr += "0" ;
         }
         currSerialNo = zeroStr + currSerialNo ;
      }

      //产生当前最大顺序号。
      long currMaxSerialNo = Long.parseLong("1"+currSerialNo)+1;

      //去掉前面一位数字。
      result = String.valueOf(currMaxSerialNo).substring(1);

      return result ;
   }

   /**
    * 截取字符串后面部分字符,后面加省略号.
    * @param str
    * @param length
    * @return
    */
   public static String trimWords(String str,int length){

      return trimWords(str,length,true) ;
   }

   /**
    * 截取字符串后面部分字符.
    * @param str
    * @param length 表示双字节长度,比如4,表示返回的字符串长度为8字节.
    * @param addPoints
    * @return
    */
   public static String trimWords(String str,int length,boolean addPoints){
      String wordStr = str ;

      if (wordStr == null || wordStr.equals("")){
         return "";
      }

      int byteLen = length * 2;
      byte[] strBytes = wordStr.getBytes();

      if(strBytes.length == str.length()){
         if (strBytes.length <= byteLen){
            return wordStr ;
         }

         byte[] trimBytes = new byte[byteLen];

         System.arraycopy(strBytes, 0, trimBytes, 0, byteLen);

         wordStr = new String(trimBytes);
      }else{
         if(wordStr.length() <= length){

            return str;
         }

         wordStr = StringUtil.left(str,length);
      }

      if(addPoints){
         wordStr += "...";
      }

      return wordStr ;
   }

   /**
    * 字符串split函数的反操作。
    * @param arr 需要反操作的字符串数组。
    * @param qutoeStr 数组元素引号字符串。
    * @param token 数组元素的分隔字符。
    * @return
    */
   public static String unSplit(String[] arr,String token,String qutoeStr){
      StringBuffer strbuf = new StringBuffer();

      if(arr == null || arr.length ==0){
         return "";
      }

      for(int i=0;i<arr.length; i++){
         if(i == arr.length-1){
            strbuf.append(qutoeStr+arr[i]+qutoeStr);
         }else{
            strbuf.append(qutoeStr+arr[i]+qutoeStr+token);
         }
      }

      return strbuf.toString();
   }

   /**
    * 测试。
    * @param args
    * @roseuid 41D398FC00CB
    */
   public static void main(String[] args)
   {
      System.out.println(StringUtil.trimWords("Yean_seraph",4,false)) ;
   }
}
