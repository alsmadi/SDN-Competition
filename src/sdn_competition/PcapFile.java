/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdn_competition;

  import java.util.Date;
  
  import org.jnetpcap.*;
  import org.jnetpcap.packet.*;
  import org.jnetpcap.util.PcapPacketArrayList;
  
  /**
   * @author Emad Heydari Beni
   * Doing some IO functions related to PCAP files.
   */
  public class PcapFile {
    
    /*************************************************
     * Local Variables
     *************************************************/
    String FileAddress = "";
    
    
    /**
     * 
     * @param FileAddress  Address and the name of the PCAP file.
     */
    public PcapFile(String FileAddress)
    {
      this.FileAddress = FileAddress;
    }
    
    /**
     * Opens the offline Pcap-formatted file. 
     * 
     * @return PcapPacketArrayList  List of packets in the file
    * @throws ExceptionReadingPcapFiles Facing any erro in opening the file
     */
    public PcapPacketArrayList readOfflineFiles() 
    {
      //First, setup error buffer and name for our file
      final StringBuilder errbuf = new StringBuilder(); // For any error msgs  
      
      //Second ,open up the selected file using openOffline call
      Pcap pcap = Pcap.openOffline(FileAddress, errbuf);
      
      //Throw exception if it cannot open the file
      if (pcap == null) {  
             // throw new ExceptionReadingPcapFiles(errbuf.toString()); 
          }
      
      //Next, we create a packet handler which will receive packets from the libpcap loop.
      PcapPacketHandler<PcapPacketArrayList> jpacketHandler = new PcapPacketHandler<PcapPacketArrayList>() {  
          
              public void nextPacket(PcapPacket packet, PcapPacketArrayList PaketsList) {  
    
                  PaketsList.add(packet);
              }  
          };
          
          /*************************************************************************** 
           * (From jNetPcap comments:)
           * Fourth we enter the loop and tell it to capture unlimited packets. The loop 
           * method does a mapping of pcap.datalink() DLT value to JProtocol ID, which 
           * is needed by JScanner. The scanner scans the packet buffer and decodes 
           * the headers. The mapping is done automatically, although a variation on 
           * the loop method exists that allows the programmer to specify exactly 
           * which protocol ID to use as the data link type for this pcap interface. 
           **************************************************************************/ 
          
          try {  
            PcapPacketArrayList packets = new PcapPacketArrayList();
            pcap.loop(-1,jpacketHandler,packets);
            
            return packets;
          } finally {  
             //Last thing to do is close the pcap handle 
             pcap.close();  
          } 
          
          
          
    }
    
    
  
  }
