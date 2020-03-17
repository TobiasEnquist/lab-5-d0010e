package supermarket;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import customers.CreateCustomer;
import customers.CustomerInformation;


public class FIFO{ //implements Queue// {
                
                
        private ArrayList<CustomerInformation> fifolist;
        
        public FIFO() {
                this.fifolist = new ArrayList<CustomerInformation>();
        }
                
                
                


                public void add (CustomerInformation arg0) {
                	
                        this.fifolist.add(arg0); //lägger till en kund i fifolistan (kassakön)
                        
                        
                        // TODO Auto-generated method stub
                        
                }


                public CustomerInformation first() throws NoSuchElementException {
                        if (this.fifolist.size()==0) {
                                throw new NoSuchElementException();
                                
                        }
                        return fifolist.get(0);
                        // TODO Auto-generated method stub
                         //kallar på första argumentet i arraylistan o returerar det
                }


                public boolean isEmpty() {
                        if (fifolist.size()==0) {
                        return true;
                                
                        }
                        else {
                        
                        return false;
                        }
                        // TODO Auto-generated method stub
                }


                public int maxSize() {
                        // TODO Auto-generated method stub
                        return fifolist.size();
                }


                public void removeFirst() throws NoSuchElementException {
                        if (fifolist.size()==0) {
                                throw new NoSuchElementException();
                        }
                        
                        this.fifolist.remove(0); //tar bort argument 0 
                        // TODO Auto-generated method stub
                        
                }


        
                public int size() {
                        
                        // TODO Auto-generated method stub
                        return this.fifolist.size(); //hämtar storleken på listan o returnerar den 
                }
                
                public boolean equals(Object f) throws ClassCastException {
                        if(this.getClass()!=((FIFO)f).getClass()){
                                throw new ClassCastException("fel");
                        
                        }
                        if(this.fifolist.size()== ((FIFO)f).size()) {
                                for(int i=0; i<fifolist.size(); i++) {
                                        if(this.fifolist.get(i)!=null && ((FIFO)f).fifolist.get(i)!=null){
                                                if (!(fifolist.get(i).equals(((FIFO) f).fifolist.get(i)))) {
                                                        return false;        
                                                }        
                                        }
                                        else if (this.fifolist.get(i)!=((FIFO)f).fifolist.get(i)) {
                                                return false;
                                        }
                                }
                                return true;
                        }
                        return false;
                        
                
                        
                }
                public String toString() {
                        String str=""; 
                        for (int i=0; i<this.fifolist.size(); i++) { //kollar först för kund 0
                                if (i!=0) {
                                        str+=", ";
                                }
                        
                        }
                        str=str+"(" + String.valueOf(fifolist.get(i)).getId();
                        return str;
                
                }


        }