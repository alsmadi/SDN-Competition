/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdn_competition;

/**
 *
 * @author IAlsmadi
 */


import java.io.IOException;
import java.util.Vector;
import java.util.*;
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.PacketReceiver;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.*;
import org.jnetpcap.*;
import java.nio.charset.Charset;
import org.jnetpcap.packet.*;
import org.jnetpcap.util.PcapPacketArrayList;
import org.jnetpcap.protocol.lan.Ethernet;  
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Tcp;
import org.jnetpcap.protocol.tcpip.Udp;
import java.io.*;
import java.nio.charset.StandardCharsets;
import org.jnetpcap.packet.*;
import org.jnetpcap.protocol.lan.Ethernet;
 import org.jnetpcap.protocol.network.Icmp;
 import org.jnetpcap.protocol.network.Ip4;
 import org.jnetpcap.protocol.network.Ip6;
import org.jnetpcap.protocol.network.Arp;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
 import java.util.Hashtable;
import java.util.List;
import java.nio.ByteBuffer;
import java.net.*;


//import com.opensoc.pcap.Constants;
//import com.opensoc.pcap.OpenSocEthernetDecoder;
//import com.opensoc.pcap.PacketInfo;
//import com.opensoc.pcap.PcapByteInputStream;
//import org.jnetpcap.*;


public class PcapReader_Main{

    public static double toDouble(byte[] bytes) {
    return ByteBuffer.wrap(bytes).getDouble();
}
	public static void readFile(String filename) {
		//System.out.println("path"+System.getProperty(java.library.path));
		System.out.println("Reading file "+filename);
		
		JpcapCaptor jpcap = null;
		// third argument is true for promiscuous mode
		try {
                    
			jpcap = JpcapCaptor.openFile(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not read pcap file "+filename);
			e.printStackTrace();
		}
		
		// we only consider network layer traffic
		// this of course means we don't see things like ARP poisoning
		try {
			jpcap.setFilter("ip", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in setting packet capture filter");
			e.printStackTrace();
		}
		
		final Data d = Data.getData();
		final Vector<SimplePacket> packet_set = new Vector<SimplePacket>();
		jpcap.loopPacket(-1, new PacketReceiver(){
			public void receivePacket(Packet p)
			{
				if(p instanceof IPPacket)
				packet_set.add(new SimplePacket((IPPacket)p));
			}
		});
		d.addPackets(packet_set.iterator());
	}
	
        static void process(){
            double totalIterations = 1000000;
    double parallelism = 64;
    double targetEvents = 1000000;
            File fin = new File("tests/southbound.pcap");
    File fout = new File(fin.getAbsolutePath() + ".parsed");
    try{
    byte[] pcapBytes = FileUtils.readFileToByteArray(fin);
    }
    catch(Exception ex){
        
    }
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < totalIterations; i++) {
    //  List<PacketInfo> list = parse(pcapBytes);
      //for (PacketInfo packetInfo : list) {
       // System.out.println(packetInfo.getJsonIndexDoc());
     // }
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Time taken to process " + totalIterations + " events :"
        + (endTime - startTime) + " milliseconds");
    System.out
        .println("With parallelism of "
            + parallelism
            + " estimated time to process "
            + targetEvents
            + " events: "
            + (((((endTime - startTime) / totalIterations) * targetEvents) / parallelism) / 1000)
            + " seconds");
    System.out.println("With parallelism of " + parallelism
        + " estimated # of events per second: "
        + ((parallelism * 1000 * totalIterations) / (endTime - startTime))
        + " events");
    System.out.println("Expected Parallelism to process " + targetEvents
        + " events in a second: "
        + (targetEvents / ((1000 * totalIterations) / (endTime - startTime))));
        }
        private final Charset UTF8_CHARSET = Charset.forName("UTF-8");

        String decodeUTF8(byte[] bytes) {
    return new String(bytes, UTF8_CHARSET);
}
        static void readBinary1(String file1){
    //         StringBuilder sb = new StringBuilder();
            OutputStream os=null;
            OutputStream os1=null;
            OutputStream os2=null;
             OutputStream os3=null;

              OutputStream os33=null;
              OutputStream os4=null;
              OutputStream os5=null;
               OutputStream os6=null;
               OutputStream os7=null;
               OutputStream os8=null;
               OutputStream os9=null;
              

            try{
              BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1),"UTF-8"));
              

    String line = null;
   // os = new FileOutputStream("out2.txt");
     os = new FileOutputStream("C:\\Users\\ialsmadi\\Desktop\\Project\\out2.txt");
    os3 = new FileOutputStream("controller1.txt");

    os33 = new FileOutputStream("controller2.txt");
    os1 = new FileOutputStream("controller.txt");
    os2 = new FileOutputStream("ports.txt");
    os4 = new FileOutputStream("hosts.txt");
    os5= new FileOutputStream("openvswitch.txt");
     os6= new FileOutputStream("openflow.txt");
     os7= new FileOutputStream("ovs-ofctl.txt");
     os8= new FileOutputStream("ovs-vsctl.txt");
     os9= new FileOutputStream("OFP-messages.txt");
//    os1 = new FileOutputStream("controller.txt");
  //  os2 = new FileOutputStream("ports.txt");

//Writer w = new OutputStreamWriter(os, "UTF-8");

    while( (line = reader.readLine()) != null){
     
           // System.out.println(line);
             byte[] bytes = line.getBytes();

            os.write(bytes);
            os.write('\n');
            os.flush();
            if(line.contains("controller")){
                 os1.write(bytes);
            os1.write('\n');
            os1.flush(); 
            }
            if(line.contains("ofp_header") || line.contains("OFPT_")){
                 os9.write(bytes);
            os9.write('\n');
            os9.flush(); 
            }
            if(line.contains("port")){
                 os2.write(bytes);
            os2.write('\n');
            os2.flush(); 
            }
            if(line.contains("ovs-ofctl")){
                 os7.write(bytes);
            os7.write('\n');
            os7.flush(); 
            }
            if(line.contains("host")){
                 os4.write(bytes);
            os4.write('\n');
            os4.flush(); 
            }
             if(line.contains("openflow")){
                 os6.write(bytes);
            os6.write('\n');
            os6.flush(); 
            }
             if(line.contains("openvswitch")){
                 os5.write(bytes);
            os5.write('\n');
            os5.flush(); 
            }

            if(line.contains("tcp:192.168.1.1:6633")){
                 os3.write(bytes);
            os3.write('\n');
            os3.flush(); 
            }
            if(line.contains("ovs-vsctl")){
                 os8.write(bytes);
            os8.write('\n');
            os8.flush();  }
             if(line.contains("tcp:192.168.1.1")){
                 os33.write(bytes);
            os33.write('\n');
            os33.flush(); 
            }

  //          sb.append(line);
      
    }
   // w.close();
    os.close();
    os1.close();
    os2.close();
    os4.close();
     os3.close();
      os33.close();
       os5.close();
        os6.close();
      os7.close();
      os8.close();
      os9.close();

//    writeToFile("Memory_Dump.txt", sb);
    
        } catch( FileNotFoundException e2 ) {
            e2.printStackTrace();
            try{
           os.close();
    os1.close();
    os2.close();

    os4.close();
     os3.close();
      os33.close();
       os5.close();
      os6.close();
      os7.close();
      os8.close();
      os9.close();
            }
            catch(Exception ex){
                
            }
        }
catch(IOException e){
    e.printStackTrace();
    try{
            os.close();
    os1.close();
    os2.close();

    os4.close();
     os3.close();
      os33.close();
       os5.close();
       os6.close();
       os7.close();
       os8.close();
       os9.close();
            }
            catch(Exception ex){
                
            }
}
        }
        static void readBinary(String file1){
            try {
            StringBuilder sb = new StringBuilder();
            File file = new File(file1);
            DataInputStream input = new DataInputStream( new FileInputStream( file ) );
            try {
           //     List<String> lines = IOUtils.readLines(input);
                while( true ) {
                    String temp= input.readUTF();
                  
                    System.out.println(temp);
                      sb.append( temp  );
                }
            } catch( EOFException eof ) {
            } catch( IOException e ) {
                e.printStackTrace();
            }
         //   System.out.println(sb.toString());
            writeToFile("Memory_Dump.txt", sb);
        } catch( FileNotFoundException e2 ) {
            e2.printStackTrace();
        }
        }
	public static void main(String[] args)
	{
    //        readBinary1("ram.raw");
             readBinary1("C:\\Users\\ialsmadi\\Desktop\\Project\\ram.raw");
            process();
            final StringBuilder SB = new StringBuilder();
            
            final StringBuilder SBIP4 = new StringBuilder();
            final StringBuilder SBIP6 = new StringBuilder();
            final StringBuilder SBICMP = new StringBuilder();
            final StringBuilder SBTCP = new StringBuilder();
            final StringBuilder SBETH = new StringBuilder();
            final StringBuilder SBARP = new StringBuilder();
            final StringBuilder SBUDP = new StringBuilder();

             final StringBuilder SBSrcDst = new StringBuilder();

            final StringBuilder SBPayLoad = new StringBuilder();
             final StringBuilder SBPackets = new StringBuilder();
            PcapFile p1 = new PcapFile("tests/southbound.pcap");
           PcapPacketArrayList p2= p1.readOfflineFiles();
            final Tcp tcp = new Tcp();  
             Ip4 ip = new Ip4();
             final Udp udp = new Udp();
             final Payload basePayload = new Payload();
            
	final Ip6 ip6 = new Ip6();
        Ethernet eth = new Ethernet();
        Arp arp = new Arp();
	final Icmp icmp = new Icmp();
          Icmp.DestinationUnreachable unreach = new Icmp.DestinationUnreachable();
             int counter=1;
             String temp="";
           for (PcapPacket entry : p2) {
               
               if(entry.hasHeader(Payload.ID)){
                SBPayLoad.append(System.getProperty("line.separator")); 
                SBPayLoad.append("Frame number..."+counter +"...");
                String payloadAsString = entry.getUTF8String(0, entry.size()); 
                byte[] data = entry.getByteArray(0, entry.size());
			//byte[] data = payload.data();
			//System.out.println("seq=" + (tcp.seq()-ISN));
			String datastr = new String(data);
			if (datastr.length() !=0) {
			    System.out.print(" data: " + datastr);
			}
			//hasData = true;
                 String sdata= new String(data);
                SBPayLoad.append(sdata);
                SBPayLoad.append(payloadAsString);
               }
                if (entry.hasHeader(ip6)){
                Ip6 ip6_header = entry.getHeader(new Ip6());
                SBIP6.append(System.getProperty("line.separator")); 
                SBIP6.append("Frame number..."+counter +"...");
                SBIP6.append(ip6_header);
 	  //  Ip4 ip4_header = entry.getHeader(new Ip4());
	    int source = ip6_header.sourceToIntHash();
            SBIP6.append(source);
	    int dest = ip6_header.destinationToIntHash();

            SBIP6.append(dest);
	    double sourceIP = toDouble(ip6_header.source());
            SBIP6.append(sourceIP);
 	    double destIP = toDouble(ip6_header.destination());
            SBIP6.append(destIP);
            SBSrcDst.append(System.getProperty("line.separator")); 
                SBSrcDst.append("Frame number..."+counter +"...");
           
 	    double sport = toDouble(ip6_header.source());
            SBIP6.append(destIP);
 	    double dport = toDouble(ip6_header.destination());
             SBSrcDst.append(source+","+sourceIP+","+sport+","+dest+","+destIP+","+dport);

            SBIP6.append(source);
	    sourceIP = toDouble(ip6_header.source());
            SBIP6.append(source);
 	    destIP = toDouble(ip6_header.destination());
            SBIP6.append(source);
 	    sport = toDouble(ip6_header.source());
            SBIP6.append(source);
 	    dport = toDouble(ip6_header.destination());

            SBIP6.append(source);
 	    String key = "" + source + dest + sport + dport;
            SBIP6.append(source);
                }
                if (entry.hasHeader(arp)){
                Arp arp_header = entry.getHeader(new Arp());
                SBARP.append(System.getProperty("line.separator")); 
                SBARP.append("Frame number..."+counter +"...");
                SBARP.append(arp_header);
 	  //  Ip4 ip4_header = entry.getHeader(new Ip4());
             //    System.out.println("ARP decode header:\t" + arp.decodeHeader());
	      System.out.println("ARP hardware type:\t" + arp. hardwareType());
	 System.out.println("ARP hw type descr:\t" + arp.hardwareTypeDescription());
	System.out.println("ARP hw type enum:\t" + arp.hardwareTypeEnum());
	System.out.println("ARP hlen:\t-\t" + arp.hlen());
	System.out.println("ARP operation:\t-\t" + arp.operation());
	 System.out.println("ARP plen:\t-\t" + arp.plen());
	 System.out.println("ARP protocol type:\t" + arp.protocolType());
	 System.out.println("ARP prtcl type descr:\t" + arp.protocolTypeDescription());
	 System.out.println("ARP prtcl type enum:\t" + arp.protocolTypeEnum());
	// System.out.println("ARP sha:\t-\t" + toDouble(mac(arp.sha()));
	 System.out.println("ARP sha length:\t-\t" + arp.shaLength());
	 //System.out.println("ARP spa:\t-\t" + FormatUtils.ip(arp.spa()));
	 System.out.println("ARP spa length:\t-\t" + arp.spaLength());
	 System.out.println("ARP spa offset:\t-\t" + arp.spaOffset());
	 //System.out.println("ARP tha:\t-\t" + FormatUtils.mac(arp.tha()));
	 System.out.println("ARP tha length:\t-\t" + arp.thaLength());
	 System.out.println("ARP tha offset:\t-\t" + arp.thaOffset());
	 //System.out.println("ARP tpa:\t-\t" + FormatUtils.ip(arp.tpa()));
	 System.out.println("ARP tpa length:\t-\t" + arp.tpaLength());
	 System.out.println("ARP tpa offset:\t-\t" + arp.tpaOffset());
	//    String state = arp_header.getState();
            SBARP.append(arp. hardwareType());
	   // int dest = arp_header.destinationToIntHash();
            SBARP.append(arp.hardwareTypeDescription());
	   // double sourceIP = toDouble(arp_header.source());
            SBARP.append(arp.hardwareTypeEnum());
 	   // double destIP = toDouble(arp_header.destination());
            SBARP.append(arp.hlen());
 	//    double sport = toDouble(arp_header.source());
            SBARP.append(arp.protocolType());
 	 //   double dport = toDouble(arp_header.destination());
            SBARP.append(arp.protocolTypeDescription());
 	//    String key = "" + source + dest + sport + dport;
            SBARP.append(arp.spaLength());
                }
                if (entry.hasHeader(ip)){
                    if (entry.hasHeader(icmp)){
                Ip4 ip4_header = entry.getHeader(new Ip4());
                 SBICMP.append(System.getProperty("line.separator")); 
                SBICMP.append("Frame number..."+counter +"...");
	    int source = ip4_header.sourceToInt();
             SBICMP.append(source);
	    int dest = ip4_header.destinationToInt();
            SBICMP.append(dest);
	    long sourceIP = ip4_header.sourceToInt();
            SBICMP.append(sourceIP);
	    long destIP = ip4_header.destinationToInt();

              SBSrcDst.append(System.getProperty("line.separator")); 
                SBSrcDst.append("Frame number..."+counter +"...");
              SBSrcDst.append(sourceIP+","+destIP);
             

            SBICMP.append(destIP);
 	    String key = "" + source + dest;
            SBICMP.append(key);
                }
             //   Tcp tcp_header = entry.getHeader(new Tcp());
 	    Ip4 ip4_header = entry.getHeader(new Ip4());
             SBIP4.append(System.getProperty("line.separator")); 
            SBIP4.append("Frame number..."+counter +"...");
            SBIP4.append(ip4_header);
             
	    int source = ip4_header.sourceToInt();
             SBIP4.append(source);
	    int dest = ip4_header.destinationToInt();
                     SBIP4.append(dest);
	    long sourceIP = ip4_header.sourceToInt();
             SBIP4.append(sourceIP);
	    long destIP = ip4_header.destinationToInt();
             SBIP4.append(destIP);
 	    byte[] sport = ip4_header.source();
             SBIP4.append(sport);
 	    byte[] dport = ip4_header.destination();
             SBIP4.append(dport);
 	    String key = "" + source + dest + sport + dport;
             SBIP4.append(key);
             
             if (entry.hasHeader(udp))  
         {  
            SBUDP.append(System.getProperty("line.separator")); 
                SBUDP.append("Frame number..."+counter +"...");
                     System.out.printf("tcp.dst_port=%d%n", udp.destination());  
                     System.out.printf("tcp.src_port=%d%n", udp.source());  
                    // System.out.printf("tcp.ack=%x%n", udp.ack()); 
                     temp="udp.dst_port=%d%n"+ udp.destination()+
                            "udp.src_port=%d%n"+ udp.source()+
                           // "tcp.ack=%x%n"+ udp.ack();
                     SB.append(temp);
                     SBUDP.append(temp);
         } 
              
                }
                if (entry.hasHeader(eth)){
             //   Tcp tcp_header = entry.getHeader(new Tcp());
 	    Ethernet eth_header = entry.getHeader(new Ethernet());
             SBETH.append(System.getProperty("line.separator")); 
            SBETH.append("Frame number..."+counter +"...");
            SBETH.append(eth_header);
             
	    int checksum = eth_header.checksum();
             SBETH.append(checksum);
	    int checksumofset = eth_header.checksumOffset();
                     SBETH.append(checksumofset);
	    long dstLG = eth_header.destination_IG();
             SBETH.append(dstLG);
	    long dstLG1 = eth_header.destination_LG();
             SBETH.append(dstLG1);
 	    byte[] sport = eth_header.source();
             SBETH.append(sport);
 	    byte[] dport = eth_header.destination();
             SBETH.append(dport);
 	    String key = "" + dstLG + dstLG1 + sport + dport;
             SBETH.append(key);
                }
                
                if (entry.hasHeader(udp)){
                Udp udp_header = entry.getHeader(new Udp());
                 SBUDP.append(System.getProperty("line.separator")); 
                SBUDP.append("Frame number..."+counter +"...");
 	    //Ip4 ip4_header = entry.getHeader(new Ip4());
	   int hlength = udp_header.getHeaderLength();
           SBUDP.append(hlength);
           int length = udp_header.getLength();
           SBUDP.append(length);
           int offset = udp_header.getOffset();
           SBUDP.append(offset);
           byte[] content=udp_header.getPayload();
           SBUDP.append(content);
           int contentSize=udp_header.getPayloadLength();
           SBUDP.append(contentSize);
	   // int dest = udp_header.destinationT
	 //   long sourceIP = udp_header.sourceToInt();
	   // long destIP = udp_header.destinationToInt();
 	    int sport = udp_header.source();
            SBUDP.append(sport);
 	    int dport = udp_header.destination();
            SBUDP.append(dport);
 	    String key = "" + sport + dport;
            SBUDP.append(key);
                }
                
               SB.append("Packet number..."+counter);
               if (entry.hasHeader(tcp)) {  
  
                    /* 
                     * Now get our tcp header definition (accessor) peered with actual 
                     * memory that holds the tcp header within the packet. 
                     */  
                 //   entry.getHeader(tcp);  
                     SBTCP.append(System.getProperty("line.separator")); 
                SBTCP.append("Frame number..."+counter +"...");
                    System.out.printf("tcp.dst_port=%d%n", tcp.destination());  
                     SBTCP.append(tcp.destination());  
                    System.out.printf("tcp.src_port=%d%n", tcp.source()); 
                     SBTCP.append(tcp.source()); 
                    System.out.printf("tcp.ack=%x%n", tcp.ack());  
                    SBTCP.append(tcp.ack());  
                    temp="tcp.dst_port=%d%n"+ tcp.destination()+
                            "tcp.src_port=%d%n"+ tcp.source()+
                            "tcp.ack=%x%n"+ tcp.ack();
                     SB.append(temp);
                }  
               if (entry.hasHeader(tcp))  
         {  
             SBTCP.append(System.getProperty("line.separator")); 
                SBTCP.append("Frame number..."+counter +"...");
                     System.out.printf("tcp.dst_port=%d%n", tcp.destination());  
                     System.out.printf("tcp.src_port=%d%n", tcp.source());  
                     System.out.printf("tcp.ack=%x%n", tcp.ack()); 
                     temp="tcp.dst_port=%d%n"+ tcp.destination()+
                            "tcp.src_port=%d%n"+ tcp.source()+
                            "tcp.ack=%x%n"+ tcp.ack();
                     SB.append(temp);
                      SBTCP.append(temp);
         } 
         if (entry.hasHeader(ip) && entry.hasHeader(tcp)) { 
              SBTCP.append(System.getProperty("line.separator")); 
                SBTCP.append("Frame number..."+counter +"...");
    // Do processing, both ip and tcp have been initialized  
              System.out.printf("tcp.dst_port=%d%n", tcp.destination());  
                     System.out.printf("tcp.src_port=%d%n", tcp.source());  
                     System.out.printf("tcp.ack=%x%n", tcp.ack()); 
                     
                     temp="tcp.dst_port=%d%n"+ tcp.destination()+
                            "tcp.src_port=%d%n"+ tcp.source()+
                            "tcp.ack=%x%n"+ tcp.ack();
                     SB.append(temp);
                     SBTCP.append(temp);
      } 
       //  Udp udp = new Udp();  
          if (entry.hasHeader(ip) && entry.hasHeader(udp)) {  
               SBUDP.append(System.getProperty("line.separator")); 
                SBUDP.append("Frame number..."+counter +"...");
    // Do processing, both ip and tcp have been initialized  
              System.out.printf("tcp.dst_port=%d%n", udp.destination());  
                     System.out.printf("tcp.src_port=%d%n", udp.source());  
                    // System.out.printf("tcp.ack=%x%n", udp.ack()); 
                    
                     temp="udp.dst_port=%d%n"+ udp.destination()+
                            "udp.src_port=%d%n"+ udp.source()+
                           // "tcp.ack=%x%n"+ udp.ack();
                     SB.append(temp);
                     SBUDP.append(temp);
                      SB.append(entry.toString());
		System.out.println("Item : " + entry.toString() + " Count : " + entry.getHeaderCount());
                              
           }
          
          if (tcp.getPayloadLength() > 0 && !entry.hasHeader(basePayload)) {
      System.out.println("Invalid packet! No payload header detected, but TCP-PayloadLength = " + tcp.getPayloadLength());
      System.out.println("------------------------------------------------------------");
      System.out.println(entry.toString());
      System.out.println("------------------------------------------------------------");
      System.out.println(entry.toHexdump());
      
          }
          boolean isSyn = false, isFin = false, hasData = false;
          int ISN = 0;

          if (entry.hasHeader(eth) && entry.hasHeader(ip) && entry.hasHeader(tcp)) {
		   // tcpCount++;
		    //System.out.print("" + (packetCount -1) + ": ");	// pld: new
               SBPackets.append(System.getProperty("line.separator")); 
                SBPackets.append("Frame number..."+counter +"...");
		    System.out.print("TCP packet: ");
		    InetAddress sourceIP = inetAddress(ip.source());
		    InetAddress destIP   = inetAddress(ip.destination());

                     SBSrcDst.append(System.getProperty("line.separator")); 
                SBSrcDst.append("Frame number..."+counter +"...");
             // SBSrcDst.append(sourceIP+","+destIP);
		    int srcport = tcp.source();
		    int dstport = tcp.destination();
                     SBSrcDst.append(sourceIP+","+srcport+","+destIP+","+dstport);
		   srcport = tcp.source();
		   dstport = tcp.destination();

		    PSocket src = new PSocket(sourceIP, srcport);
		    PSocket dest =new PSocket(destIP,   dstport);
		    System.out.print( src + " ==> " + dest);
                    
                    SBPackets.append(src + " ==> " + dest);
		    if (tcp.flags_SYN()) {
			//synCount++;
			if (tcp.flags_ACK()){ System.out.print(" SYN/ACK, ");
                         SBPackets.append(" SYN/ACK, ");
                        }
			else {
                            System.out.print(" first SYN, ");
                             SBPackets.append(" first SYN, ");
                        }
			ISN = (int) tcp.seq();
			System.out.print("ISN=" + ISN);
                        SBPackets.append("ISN=" + ISN);
			isSyn = true;
		    }
		    if (tcp.flags_FIN()) {
			System.out.print(" FIN");
                         SBPackets.append("FIN");
			isFin = true;
		    }
		    if (tcp.flags_RST()) {
			System.out.print(" RST");
                        // should handle better?
                         SBPackets.append("RST");
			isFin = true;
		    }
		    
		    if (entry.hasHeader(basePayload) && tcp.getPayloadLength() != 0 ) {
			byte[] data = basePayload.getByteArray(0, basePayload.size());
			//byte[] data = payload.data();
			//System.out.println("seq=" + (tcp.seq()-ISN));
			String datastr = new String(data);
			if (datastr.length() !=0) {
			    System.out.print(" data: " + datastr);
			}
			hasData = true;
		    }
		    if (!isSyn && !isFin && !hasData){
			System.out.print(" ACK only");
                         SBPackets.append(" ACK only");
                    }
		    System.out.println();
		} else {
               SBPackets.append(System.getProperty("line.separator")); 
                SBPackets.append("Frame number..."+counter +"...");
			System.out.println("... not a TCP packet");
                         SBPackets.append(" ... not a TCP packet");
		}
          counter++;
      } 
         
	writeToFile("Flow_Dump.txt", SB);
        writeToFile("IPv4.txt", SBIP4);
        writeToFile("IPv6.txt", SBIP6);
         writeToFile("TCP.txt", SBTCP);
        writeToFile("UDP.txt", SBUDP);
         writeToFile("ICMP.txt", SBICMP);
         writeToFile("Eth.txt", SBETH);
         writeToFile("ARP.txt", SBARP);
         writeToFile("PayLoad.txt", SBPayLoad);
         writeToFile("Packets.txt",SBPackets);

         writeToFile("SrcDst.txt",SBSrcDst);

        //writeToFile("IPv6.txt", SBIP6);
    /*       File file = new File("Flow_Dump.txt");
           BufferedWriter writer=null;
try {
    writer = new BufferedWriter(new FileWriter(file));
    writer.write(SB.toString());
} 
catch(Exception ex){
}

    finally {
    if (writer != null) 
        try{writer.close();
        
        }
    catch(Exception ex){
} 
}*/
		Data d = Data.getData();
		//readFile("tests/southbound.pcap");
		System.out.println("Data now has "+d.getIPGraph().getNodeCount()+" nodes!");
	}
        
        /**
 * inetAddress(byte[] buf): converts an array of four bytes to an InetAddress
 */
    private static InetAddress inetAddress(byte[] buf) {
	InetAddress addr = null;
	try {
		addr = InetAddress.getByAddress(buf);
	} catch (UnknownHostException uhe) {}
	return addr;
    }

        static void writeToFile(String name, StringBuilder SB){
            
            File file = new File(name);
           BufferedWriter writer=null;
try {
    writer = new BufferedWriter(new FileWriter(file));
    writer.write(SB.toString());
} 
catch(Exception ex){
}

    finally {
    if (writer != null) 
        try{writer.close();
        
        }
    catch(Exception ex){
}
}     }
}
