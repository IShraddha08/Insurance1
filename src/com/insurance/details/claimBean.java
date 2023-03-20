package com.insurance.details;
import java.util.Date;
public class claimBean {
	
	    private String reclaim;
		private String dparts;
		private String tdamage;
		private Date dissue;
		private int sum; 
		
		
		public String getreclaim() {
			return reclaim;
		}
		public void setreclaim(String reclaim) {
			this.reclaim = reclaim;
		}
		public String getdparts() {
			return dparts;
		}
		public void setdparts(String dparts) {
			this.dparts = dparts;
		}
		public String gettdamage() {
			return tdamage;
		}
		public void settdamage(String tdamage) {
			this.tdamage = tdamage;
		}
			
		public Date dissue() {
				return dissue;
			}
			public void setdissue(Date dissue) {
				this.dissue = dissue;
			}
			
		public int getsum() {
				return sum;
			}
			public void setsum(int sum) {
				this.sum = sum;
			}
		
		}


