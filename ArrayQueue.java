

public class ArrayQueue implements Queue
{
    Object array1[] ;
    int capacity ;
    int size = 0 ;
    //int index = 0 ;
    int front , rear ;

    public ArrayQueue()
     {
		 capacity = 2 ;
		 array1 = new Object[capacity] ;
		 //index = 0 ; //next empty one
         front = 0;
         rear = capacity - 1;
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

	public void enqueue(Object item)
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

        rear = (rear+1) % capacity ;
        array1[rear] = item  ;
         size++ ;
        System.out.println( item + " enqueued to queue");

	 }

	public Object dequeue()
	{
		if( size == 0 )
		  return null ;
	    Object item = array1[front] ;
	    front = ( front + 1 ) % capacity ;
	    size-- ;
	    return ( item ) ;
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
		ArrayQueue queObject1 = new ArrayQueue() ;
        queObject1.enqueue( "ajay" ) ;
        queObject1.enqueue( "kumar" ) ;
        queObject1.enqueue( "ajay1" ) ;
        queObject1.enqueue( "kumar1" ) ;
        System.out.println( queObject1.dequeue()  ) ;
        System.out.println( queObject1.dequeue()  ) ;
        System.out.println( queObject1.dequeue()  ) ;
        System.out.println( queObject1.dequeue()  ) ;
	}


}
