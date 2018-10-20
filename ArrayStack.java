import java.util.* ;


public class ArrayStack implements Stack
{
    Object array1[] ;
    final int INTIAL_CAPACITY = 2  ;
    int capacity ;
    int size = 0 ;
    int index = 0 ;

    public ArrayStack()
     {
		 capacity = 2 ;
		 array1 = new Object[capacity] ;
		 index = 0 ; //next empty one
	 }

    public void print()
    {
		System.out.println(  Arrays.toString(array1)  )   ;
	}

    public void resize()
    {
      int oldCapacity = capacity ;
      capacity *= 2 ;
      Object newArray[] = new Object[ capacity ] ;
      for( int i1=0 ; i1< array1.length ; i1++ )
        newArray[i1] = array1[i1] ;
      array1 = newArray ;
	}

	public void push(Object item)
	 {
        if( size == capacity )
          resize() ;


        if( item instanceof String)
        {
	        String item1 = ( String) item ;

	        if( item1.length() == 1 && (item1.indexOf("!") > -1   || item1.indexOf(" ") > -1)
	        		)
	        	return ;

	        item1 = item1.toLowerCase() ;
	        item1 = item1.replaceAll("\\s+","")  ;
	        item = item1.replaceAll("\\!",  "");
        }

        array1[index++] = item ;
        size++ ;
	 }
	public Object pop()
	{
		if( size == 0 )
		  return null ;
		int ind1 = index-1 ;
		index-- ;
		size-- ;
        return ( array1[index] ) ;
	}

	public Object peek()
	{
		if( size == 0 )
		  return null ;
        return ( array1[index-1] ) ;

	}


	public boolean empty()
	{
		if( size == 0 )
		  return true ;
		else
		  return false ;

	}

 public static void main(String args[] )
    {
        ArrayStack arr1 = new ArrayStack() ;
        arr1.push( "Ajay" );
        arr1.push( "Kumar" ) ;arr1.push( "Kumar2" ) ;arr1.push( "Kumar3" ) ;

        System.out.println( arr1.pop() )  ;
        System.out.println(  arr1.pop() ) ;

        System.out.println( arr1.pop() )  ;
        System.out.println(  arr1.pop() ) ;

	}


}
