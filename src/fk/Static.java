package fk;

public class Static {
	static int t = 20;
	static int h = 20;
	static double a = 0.11;
	static int p = 150;
	static String pollution ="";
	static String fire ="";
	static int f = 800;

	static int t1 = 30;
	static int h1 = 30;
	static int t2 = 30;
	static int h2 = 30;
	static int t3 = 30;
	static int h3 = 30;
	static int t4 = 30;
	static int h4 = 30;
	static int t5 = 30;
	static int h5 = 30;


	static int getT(String name) {
		switch(name){
			case "1" :
				return t1;
			case "2" :
				return t2;
		    case "3" :
		    	return t3;
		    case "4" :
		    	return t4;
		    case "5" :
		    	return t5;
		}
		return t;
	}

	//Flicker
//	static JPanel getF(String name) {
//		switch(name){
//			case "1" :
//				return jPanel1;
//			case "2" :
//				return jPanel2;
//			case "3" :
//				return jPanel3;
//			case "4" :
//				return jPanel4;
//			case "5" :
//				return jPanel5;
//		}
//		return null;
//	}

	static int getH(String name) {
		switch(name){
			case "1" :
				return h1;
			case "2" :
				return h2;
		    case "3" :
		    	return h3;
		    case "4" :
		    	return h4;
		    case "5" :
		    	return h5;
		}
		return h;
	}

	static void setchange(String name) {
		switch(name){
			case "1" :
				t1=t;
				h1=h;
				break;
		    case "2" :
		    	t2=t;
				h2=h;
		    	break; //可选
		    case "3" :
		    	t3=t;
				h3=h;
		    	break;
		    case "4" :
		    	t4=t;
				h4=h;
		    	break;
		    case "5" :
		    	t5=t;
				h5=h;
		    	break;
		    //你可以有任意数量的case语句
		}
	}
}
