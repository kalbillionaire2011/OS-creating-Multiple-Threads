/* Author: Colin SuarezWhite
 * 3/12/2021
 * 
 * */
public class Pid_manager2 {
	  //declaring minimum pid and maximum pid
    private int MIN_PID = 300;
    private int MAX_PID = 5000;
    //pid map of type boolean this acts like a bitmap 
    private boolean pid_map[];

    public int allocate_map()
    {
            //find the size of the map that is equal to the max pid - min pid
            int size = MAX_PID - MIN_PID;
            //allocating memory for the pid map
            pid_map = new boolean[size];
            //incase the map is null i.e allocation is failed we return -1
            if(pid_map == null)
                    return -1;
            //initializing the map with false values
            for(int i=0;i<size;i++)
            {
                    pid_map[i] = false;
            }
            //returning 1
            return 1;
    }

    public int allocate_pid()
    {
            /*
                    for allocating a pid we traverse the pid_map from start to end if we find any 
                    free entry i.e having a false value we replace the false value with true and return 
                    that pid
            */
            int pid = 0;
            int size = MAX_PID - MIN_PID;
            //traverse untill we find a false value and pid vale is not equal to size  
            while(  pid!=size && pid_map[pid] != false )
            {
                    pid++;
            }
            //if the value of pid is equal to the size of the map then all the pid's are occupied
            //so we return -1
            if(pid == size)
            {
                    return -1;
            }
            //replace the false value with true
            pid_map[pid] = true;
            //return the pid + MIN_PID to bring the pid within range of MIN_PID and MAX_PID
            return pid+MIN_PID;
    }

    public void release_pid(int pid)
    {
            //just replace the  false with true in the pid_map for corresponding pid - MIN_PID value
            pid_map[pid-MIN_PID] = false;
    }
    //Test method to test the functionality of the above methods
    public static void main(String[] args) 
    {
    				 int pid;
    		/* I create a PID object to processed */
            Pid_manager2 pm = new Pid_manager2();
            if(pm.allocate_map() != -1)
            {
                     pid = pm.allocate_pid();
                    if(pid!=-1){
                            System.out.println("Process allocated with PID :"+ pid);
                            pm.release_pid(pid);
                            System.out.println("Process with PID :" + pid + " released");
                    }
                    else
                    {
                            System.out.println("Process cannot be allocated");
                    }
            }
            else{
                    System.out.println("Error in allocating PID map");
            }
            int sleep(int z){
            	
            }

    }
}
