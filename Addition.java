//addition of local,instance and static variables
class Addition{
	int d=7,e=8;
	static int g=9, h=10;
	public static void main(String args[]){
		int a=10,b=5,c,i;
		int f;
		Addition ob=new Addition();
		c=a+b;
		System.out.println("Local Sum = "+c);
		
		f=ob.d+ob.e;
		System.out.println("Instance Sum = "+f);
		
		i=g+Addition.h;
		System.out.println("Static sum = "+i);

	}
}