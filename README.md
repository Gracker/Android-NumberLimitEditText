Android-NumberLimitEditText
===========================

NumberLimitEditText是一个Android中的EditText. 当用户输入到一定长度(可以自己设定)后,会提示用户不要再继续输入了.

#背景 
Android的EditText的输入可以限定输入的字数,比如:  

		editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(n)});

或者在xml中设置:  
		
		android:maxLength

这样设置很方便,但是无法实现这样的功能:当限定最大长度之后,用户再进行输入,要给用户一定的提示,告诉用户已经到达了最大长度,不能再进行输入了.  
基于这样的考虑,NumberLimitEditText是一个可以限定最大输入Number的EditText,当用户输入到达最大长度后,还进行输入的话,就弹出Toast来告诉用户:不能再输入了!!

#Usage
这个类的使用很简单,讲NumberLimitEditText.java放入项目的包中,然后再xml中对其进行应用:  

		<com.gracker.numberlimitedittext.NumberLimitEditText 
        	android:layout_width="fill_parent"
        	android:layout_height="wrap_content"
        	android:hint="input your name "
        	android:id = 
        />
在代码中获得NumberLimitEditText的实例后,可通过这两个方法:  
	
	    public void setTextCount(int mTextCount) {
       	 	this.mTextCount = mTextCount;
   		 }
		
		public void setToastLog(String mToastLog) {
        	this.mToastLog = mToastLog;
    	}
来设置可以输入的最大长度和输入达到最大长度后的提示.