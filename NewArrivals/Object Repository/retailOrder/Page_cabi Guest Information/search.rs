<?xml version="1.0" encoding="UTF-8"?>
<WebElementEntity>
   <description></description>
   <name>search</name>
   <tag></tag>
   <elementGuidId>41ef5b73-58cf-4dc3-b837-fbe28bc24c31</elementGuidId>
   <selectorCollection>
      <entry>
         <key>XPATH</key>
         <value>//div[@id='wrapper']</value>
      </entry>
   </selectorCollection>
   <selectorMethod>XPATH</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>tag</name>
      <type>Main</type>
      <value>div</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>id</name>
      <type>Main</type>
      <value>wrapper</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>
  

    #consolidatedSearch {
        padding: 4px 5px 3px 25px;
        border-radius: 5px;
        border: none;
        width: 0;
        cursor: pointer;
        background: url('/static/images/icon-search-black.png') no-repeat 5px;
        background-size: 15px;
        line-height: inherit;
    }

    .fullSearchInput {
        cursor: text !important;
        border: solid #aaa 1px !important;
    }

    #consolidatedSearchError {
        position: absolute;
        float: right;
        width: 160px;
        color: white;
        background: #D22C2B;
        padding: 5px 10px;
        font-size: 14px;
        display: none;
        margin: 5px 0 0 1px;
    }



    
        cabi
        
            Welcome Test  Consultant 2
            Home
            
            CLIO Central
             
            Log Out »
        
        
        
            

             Shows &amp; Orders
                
                     Create A Show     
                   
                
                     Manage My Shows
                   
                   
                       Show RSVP Report
                   
                  
                     Orders
                    
                   

					  Product Watch List
                   
                        
                            Backorders
                        
                        
                            RMA»
                            
                                RMA Dashboard
                                Find RMA
                                  Refund Status
                            
                        
                       
                   
                 
						Retail Orders
						Personal Purchases
						Online Outlet Store
				
					
                
                      
                
                
                Reports
                        

                        

                        My Team


                            Team Historical Summary
                         Leadership Dashboard
                            Earnings Reports
                        
                         BIB Leader Report
                            Set/Edit Goals
                             Goals Dashboard
                            Serve &amp; Soar Report
                            New Arrival Reservation
                             Milestone Report
                        ACH &amp; Credit Card Report
                        Gift Cards List
                        Customer Purchase History
                        Personal Purchase Tracker
                        Email Deliverability Report
                        Sales by Category
				    
                
                
                    Connections
                    
	                       Contact Manager
                  
                
                         Hostess Benefits
                           Jewelry Benefits  
                       My Applicants    
							My Leads
                                       
                                                                     
                              
                Account
                    
                        My Profile
                        My Lead Information
                        Change Password
                        
                        My Exceptions
                        Request Exception
                        Seasonal Inventory Payments
                        clio go
                        
                                               
                    
                
        
            
                
                Please input three or more characters
            
    








    
        
            Coloring Legends
        
                        
            
                 
                Green background is shown if consultant did meet or is projected to beat their minimums by more than 10%.                
            
            
            
                 
                Yellow background is shown if consultant is within 10% positive/negetive of making their goal given current rate.This color is never shown for past months.
            
            
                 
                Red background is shown if consultant did not /will not meet  their minimum given current rate.For current month this means they are not projected to make 90% of their minimum.                
            
            
        
            
                
                            
                    
    











$(&quot;#consolidatedSearch&quot;).on('keyup', function (e) {
    if ($(this).val().length > 2) {
        $(&quot;#consolidatedSearchError&quot;).slideUp();
    }
    if (e.keyCode == 13) {
        if ($(this).val().length &lt; 3) {
            $(&quot;#consolidatedSearchError&quot;).slideDown();
        } else {
            window.open('/backoffice/control/ConsolidatedSearch?query=' + $(this).val(), &quot;_blank&quot;);
        }
    }
});
$(&quot;#consolidatedSearch&quot;).click(function () {
    $(this).addClass(&quot;fullSearchInput&quot;);
    $(this).animate({ width: &quot;150px&quot; }, 500);
});
$(&quot;#consolidatedSearch&quot;).blur(function () {
    $(&quot;#consolidatedSearchError&quot;).slideUp('slow', function () {
        $(&quot;#consolidatedSearch&quot;).removeClass(&quot;fullSearchInput&quot;);
        $(&quot;#consolidatedSearch&quot;).animate({ width: &quot;0&quot; }, 500);
    });
});
function blinkeffect(selector) {
	$(selector).fadeOut('slow', function() {
		$(this).fadeIn('slow', function() {
			blinkeffect(this);
		});
	});
}
function closepopup(){
$('#legandDiv').hide();    
$(&quot;#blackShadow&quot;).hide();
} 
$(&quot;.invitation-search-box&quot;).keyup(function (evt) {
var charCode = evt.charCode || evt.keyCode;
var searchValue =  $(&quot;.invitation-search-box&quot;).val();
if (charCode  == 13) { 

    searchValue =  $(&quot;.invitation-search-box&quot;).val();
    if (searchValue== &quot;Search Contacts&quot;){
    searchValue=&quot;&quot;;
    }
 $.ajax({
    type: &quot;POST&quot;,
      url: '/retail/control/ShowSendInvitationsFilter?&amp;guestFilter=' + searchValue + '',
    data: $(&quot;#ScheduleInviteForm&quot;).serialize(),        
    success: function(data, textStatus, jqXHR) {
       if(data.result){
       $(&quot;#guest-list-table&quot;).empty();
       $.each(data.result, function(i, item){
       var str = '&lt;li class=&quot;guest-row&quot;>';
       str += '&lt;input type=&quot;checkbox&quot; id=&quot;' + item.partyId + '&quot; class = &quot;case&quot; name=&quot;selectedGuests&quot; value=&quot;' + item.partyId + '&quot;/>&lt;em>&lt;span class=&quot;full-name&quot;>' + item.firstName + '&amp;nbsp;' + item.lastName + '&lt;/span>&lt;/em>';  
       str += '&lt;/li>';
       $(&quot;#guest-list-table&quot;).append(str);
       }
        )}else{
            alert('No Information available for this Filter...');
        }
    },
    error: function(xhr, status, error) {
        alert('error:'+error)            
    }        
});

    }    
    return false;
});
function guestSorting(sortField,sortDir){
    searchValue =  $(&quot;#searchContact&quot;).val();
    if (searchValue== &quot;Search Contacts&quot;){
    searchValue=&quot;&quot;;
    }
 $.ajax({
    type: &quot;POST&quot;,
      url: '/retail/control/ShowSendInvitationsFilter?&amp;guestFilter=' + searchValue + '&amp;sortField=' + sortField + '&amp;sortdir=' + sortDir + '',
    data: $(&quot;#ScheduleInviteForm&quot;).serialize(),        
    success: function(data, textStatus, jqXHR) {
       if(data.result){
       $(&quot;#guest-list-table&quot;).empty();
       $.each(data.result, function(i, item){
       var str = '&lt;li class=&quot;guest-row&quot;>';
       str += '&lt;input type=&quot;checkbox&quot; id=&quot;' + item.partyId + '&quot; class = &quot;case&quot; name=&quot;selectedGuests&quot; value=&quot;' + item.partyId + '&quot;/>&lt;em>&lt;span class=&quot;full-name&quot;>' + item.firstName + '&amp;nbsp;' + item.lastName + '&lt;/span>&lt;/em>';  
       str += '&lt;/li>';
       $(&quot;#guest-list-table&quot;).append(str);
       }
        )}else{
            alert('No Information available for this Filter...');
        }
    },
    error: function(xhr, status, error) {
        alert('error:'+error)            
    }        
});

}

$(&quot;#primary-search-box&quot;).keyup(function(event) {
		if (event.which == 13) {
			var text =  $('#primary-search-box').val();
var url;
if( text.length&lt;3) {
    alert(&quot;Please enter atleast 3 characters&quot;);
    return false;
} 
if(isNaN( text )==false) {
    
    if( text.length&lt;5) {
        alert(&quot;Please enter atleast 5 digits&quot;);
        return false;
    } else {
        url=&quot;findReturn?returnId=&quot;+text+&quot;&amp;searchFor=return&quot;;
    }
} else {
    if((text.substr(0, 2).toUpperCase()=='SH' || text.substr(0, 2).toUpperCase()=='PR' || text.substr(0, 2).toUpperCase()=='FT' || text.substr(0, 2).toUpperCase()=='RS' || text.substr(0, 2).toUpperCase()=='RT' || text.substr(0, 2).toUpperCase()=='SL' || text.substr(0, 2).toUpperCase()=='SP') &amp;&amp; text.length >=7  &amp;&amp; isNaN(text.substr(2, 5))==false) {
        url = 'OrderLookup?orderId='+text;
    } else {
        data = '?textValue='+text+'&amp;searchFor=contact';
        url='SearchContact'+data;
        
    }
}
var isMatch = text.substr(0, 2);
var orderLookupText = 'RT10000'
var searchBy=&quot;orderId&quot;;
window.location.href=url;
		}
	});
	

	
	$(&quot;#select_all&quot;).on(&quot;click&quot;, function(event){
		  $('.case').prop('checked', this.checked);
	});
	$(&quot;.case&quot;).on(&quot;click&quot;, function(event){
		if($(&quot;.case&quot;).length == $(&quot;.case:checked&quot;).length) {
			$(&quot;#select_all&quot;).prop(&quot;checked&quot;, &quot;checked&quot;);
		} else {
			$(&quot;#select_all&quot;).removeAttr(&quot;checked&quot;);
		}

	});
	
	
$(&quot;#searchContact&quot;).keypress(function(){
var lengthSearch = $(&quot;#searchContact&quot;).val().length;
if(lengthSearch>2){
var sortOrder = $(&quot;#sortOrder&quot;).val();
if (sortOrder ==&quot;&quot; || sortOrder == null)
sortOrder = &quot;firstName&quot;;
guestSorting(sortOrder,'DESC');
}
if(lengthSearch==0){
var sortOrder = $(&quot;#sortOrder&quot;).val();
if (sortOrder ==&quot;&quot; || sortOrder == null)
sortOrder = &quot;firstName&quot;;
guestSorting(sortOrder,'DESC');

}
});

$(&quot;#searchContact&quot;).keydown(function(){
var lengthSearch = $(&quot;#searchContact&quot;).val().length;
if(lengthSearch==0){
var sortOrder = $(&quot;#sortOrder&quot;).val();
if (sortOrder ==&quot;&quot; || sortOrder == null)
sortOrder = &quot;firstName&quot;;
guestSorting(sortOrder, 'DESC');
}
});
$(&quot;#searchContact&quot;).keyup(function(){
var lengthSearch = $(&quot;#searchContact&quot;).val().length;
if(lengthSearch==0){
var sortOrder = $(&quot;#sortOrder&quot;).val();
if (sortOrder ==&quot;&quot; || sortOrder == null)
sortOrder = &quot;firstName&quot;;
guestSorting(sortOrder,'DESC');
}
});

$(document).ready(function() {
	/*Start Code for Dashboard will be visible on page load*/
	if(window.location.href.indexOf(&quot;/backoffice/control/main&quot;) > -1 || window.location.href.indexOf(&quot;/backoffice/control/login&quot;) > -1) {		
		$(&quot;.blink-control&quot;).show();
		blinkeffect('.blink-control');
	} else {
		$(&quot;.blink-control&quot;).hide();
	}
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function()
    { (i[r].q=i[r].q||[]).push(arguments)}
    ,i[r].l=1*new Date();a=s.createElement(o),
    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
    ga('create', 'UA-46365838-1', 'auto');
    ga('send', 'pageview');

});	

/* CABC-14993 : Created a function [preventLoadingAndUpdateUrl] which will prevent the deault functioning of top header links (&lt;a> of My Account etc.)
 and will append the url at the end. This is done because when user clicks on top header links after order creation
 then the same request of submitOrder triggers since the top header links were refreshing the page.
 */
function preventLoadingAndUpdateUrl(self, event) {
    event.preventDefault(event);
    var url = self.attr('href');
    window.history.replaceState(null, null, url);
    return false;
}
 
   
	
                

    
        X
                
         
                  
         
         
            
            
                 
                   Search for your Share It, Sister leader by entering their email address in the field provided below:
                
                 
                  
                  Leader Stylist ID or Email
                
                 
                  
                   
                
                  
                  Your Leader
                    Your Leader
                  Gift Card
                
             
              
	         
	         	  
	         
	         
		
			




    
        X
                
         
         
         
         
            
            
                 
                   Search for your Book It, Baby! Leader	and Accountability partner by entering their email address in the fields provided below.
                
                 
                  
                  Leader Stylist ID or Email
                
                 
                  
                   
                
                  
                  Your Leader
                    Your Leader
                  Gift Card
                
             
              
	         
	              
                  Accountability Partner Stylist ID or Email
                
	              
                   
                   
                
	             
	              Your Accountability Partner
                    Your Accountability Partner
                  Gift Card
                
	         
	          
             
                  
                  2nd Accountability Partner Stylist ID or Email (optional)
                
                  
                   
                   
                
                 
                  Your 2nd Accountability Partner
                    Your 2nd Accountability Partner
                  Gift Card
                
             
	         
	         
	         
	         	  
	         
	         
		
			





$(&quot;.colorbox_importcrossbtn&quot;).click(function() {
    $.colorbox.close();
})
function showPopup() {
    $.colorbox({
        inline: true,
        href: '#enrollBIB',
        top: 10,
        width: 600
    });
}
function showSISPopup() {
    $.colorbox({
        inline: true,
        href: '#enrollSIS',
        top: 10,
        width: 600
    });
}

function showMessage() {
	alert(&quot;Sorry, This feature is not accessible right now.&quot;);
}

function closePopup() {
    $.colorbox.close();
}

function searchConsultant(stylistName, feildId) {
var stylistId = $(&quot;#&quot;+feildId).val();
if(stylistId == &quot;&quot;) {
$(&quot;#&quot;+stylistName).addClass(&quot;error-message&quot;)
$(&quot;#&quot;+stylistName).text(&quot;There was no stylist found with that information&quot;);
if(feildId == &quot;apLeadId&quot;) {
   $(&quot;#apText&quot;).hide();
    $(&quot;#apLeadPartyId&quot;).val(&quot;&quot;);
   } else {
    $(&quot;#leadText&quot;).hide();
    $(&quot;#bibLeadPartyId&quot;).val(&quot;&quot;);
   }
 $.colorbox.resize();
} else {
jQuery.ajax({
        url: '/retail/control/searchConsultantData',
        async: false,
        type: 'POST',
        data: {searchParam: stylistId},
        success: function (data) {
           if(data != &quot;&quot; &amp;&amp; data != &quot;undefined&quot; &amp;&amp; !jQuery.isEmptyObject(data[&quot;consultantList&quot;])) {
           $(&quot;#&quot;+stylistName).removeClass(&quot;error-message&quot;);
           $(&quot;#&quot;+stylistName).text(&quot;&quot;+data[&quot;consultantList&quot;].name);
           if(feildId == &quot;apLeadId&quot;) {
            $(&quot;#apText&quot;).show();
            $(&quot;#apTxt&quot;).hide();
            $(&quot;#apLeadPartyId&quot;).val(&quot;&quot;+data[&quot;consultantList&quot;].partyId);
           } else if(feildId == &quot;secondApLeadId&quot;) {
            $(&quot;#secondApText&quot;).show();
            $(&quot;#secondApTxt&quot;).hide();
            $(&quot;#secondApLeadPartyId&quot;).val(&quot;&quot;+data[&quot;consultantList&quot;].partyId);
           } else {
            $(&quot;#leadText&quot;).show();
            $(&quot;#leadTxt&quot;).hide();
            $(&quot;#bibLeadPartyId&quot;).val(&quot;&quot;+data[&quot;consultantList&quot;].partyId);
           }
          } else {
	         if(feildId == &quot;apLeadId&quot;) {
	            $(&quot;#apText&quot;).hide();
	            $(&quot;#apLeadPartyId&quot;).val(&quot;&quot;);
	          } else if(feildId == &quot;secondApLeadId&quot;) {
                $(&quot;#secondApText&quot;).hide();
                $(&quot;#secondApLeadPartyId&quot;).val(&quot;&quot;);
             } else {
	            $(&quot;#leadText&quot;).hide();
	            $(&quot;#bibLeadPartyId&quot;).val(&quot;&quot;);
	           }
            $(&quot;#&quot;+stylistName).addClass(&quot;error-message&quot;)
            $(&quot;#&quot;+stylistName).text(&quot;There was no stylist found with that information&quot;)
          }
          $.colorbox.resize();
         }
    });
  }
}


function searchSISConsultant(stylistName, feildId) {
var stylistId = $(&quot;#&quot;+feildId).val();
if(stylistId == &quot;&quot;) {
$(&quot;#&quot;+stylistName).addClass(&quot;error-message&quot;)
$(&quot;#&quot;+stylistName).text(&quot;There was no stylist found with that information&quot;);
if(feildId == &quot;sisApPartyId&quot;) {
   $(&quot;#apText&quot;).hide();
    $(&quot;#sisApLeadPartyId&quot;).val(&quot;&quot;);
   } else {
    $(&quot;#leadText&quot;).hide();
    $(&quot;#sisLeadPartyId&quot;).val(&quot;&quot;);
   }
 $.colorbox.resize();
} else {
jQuery.ajax({
        url: '/retail/control/searchConsultantData',
        async: false,
        type: 'POST',
        data: {searchParam: stylistId},
        success: function (data) {
           if(data != &quot;&quot; &amp;&amp; data != &quot;undefined&quot; &amp;&amp; !jQuery.isEmptyObject(data[&quot;consultantList&quot;])) {
           $(&quot;#&quot;+stylistName).removeClass(&quot;error-message&quot;);
           $(&quot;#&quot;+stylistName).text(&quot;&quot;+data[&quot;consultantList&quot;].name);
           if(feildId == &quot;sisApPartyId&quot;) {
            $(&quot;#apText&quot;).show();
            $(&quot;#apTxt&quot;).hide();
            $(&quot;#sisApLeadPartyId&quot;).val(&quot;&quot;+data[&quot;consultantList&quot;].partyId);
           } else if(feildId == &quot;secondSISApPartyId&quot;) {
            $(&quot;#secondApText&quot;).show();
            $(&quot;#secondApTxt&quot;).hide();
            $(&quot;#secondSISApLeadPartyId&quot;).val(&quot;&quot;+data[&quot;consultantList&quot;].partyId);
           } else {
            $(&quot;#leadText&quot;).show();
            $(&quot;#leadTxt&quot;).hide();
            $(&quot;#sisLeadPartyId&quot;).val(&quot;&quot;+data[&quot;consultantList&quot;].partyId);
           }
          } else {
	         if(feildId == &quot;sisApLeadPartyId&quot;) {
	            $(&quot;#apText&quot;).hide();
	            $(&quot;#sisApLeadPartyId&quot;).val(&quot;&quot;);
	          } else if(feildId == &quot;secondSISApLeadPartyId&quot;) {
                $(&quot;#secondApText&quot;).hide();
                $(&quot;#secondSISApLeadPartyId&quot;).val(&quot;&quot;);
             } else {
	            $(&quot;#leadText&quot;).hide();
	            $(&quot;#sisLeadPartyId&quot;).val(&quot;&quot;);
	           }
            $(&quot;#&quot;+stylistName).addClass(&quot;error-message&quot;)
            $(&quot;#&quot;+stylistName).text(&quot;There was no stylist found with that information&quot;)
          }
          $.colorbox.resize();
         }
    });
  }
}

function saveLeads(stylistName, feildId) {
var bibLeadPartyId = $(&quot;#bibLeadPartyId&quot;).val();
var apLeadPartyId = $(&quot;#apLeadPartyId&quot;).val();
var secondApLeadPartyId = $(&quot;#secondApLeadPartyId&quot;).val();
if((apLeadPartyId != &quot;&quot; &amp;&amp; bibLeadPartyId != &quot;&quot;)) {
jQuery.ajax({
        url: '/retail/control/enrollLeads',
        async: false,
        type: 'POST',
        data: {bibLeadPartyId: bibLeadPartyId,apLeadPartyId:apLeadPartyId,secondApLeadPartyId:secondApLeadPartyId},
        success: function (data) {
           $(&quot;#bidwidget&quot;).hide();
           $(&quot;#bibbadge&quot;).show();
           $.colorbox.close();
           if(window.location.href.indexOf(&quot;/backoffice/control/ViewMyProfile&quot;) > -1) {
                  window.location.reload(true);
           }
         }
    });
} else {
     alert(&quot;Please select  both Leader And Accountability partner&quot;);
}
}

function saveSISLeads(stylistName, feildId) {
var sisLeadPartyId = $(&quot;#sisLeadPartyId&quot;).val();
var sisApLeadPartyId = $(&quot;#sisApLeadPartyId&quot;).val();
var secondSISApLeadPartyId = $(&quot;#secondSISApLeadPartyId&quot;).val();
if((sisLeadPartyId != &quot;&quot;)) {
	jQuery.ajax({
        url: '/retail/control/enrollLeads',
        async: false,
        type: 'POST',
        data: {sisLeadPartyId: sisLeadPartyId},
        success: function (data) {
           $(&quot;#siswidget&quot;).hide();
           $(&quot;#sisbadge&quot;).show();
           $.colorbox.close();
           if(window.location.href.indexOf(&quot;/backoffice/control/ViewMyProfile&quot;) > -1) {
                  window.location.reload(true);
           }
         }
    });
} else {
     alert(&quot;Please select your Leader&quot;);
}
}
     

.ui-datepicker-month, .ui-datepicker-year {font-size: 1em;}
.fadeOut {color:#D3D3D3}


 
		X
	 	
			Shows				
		
		
		
		
	


	My Dashboard
	My Dashboard


	
		@@value@@
	


	
		@@value@@
	


		@@value@@


		@@value@@



	
		
			
			TASKS
			SHOWS
			LIBRARY
			cabiYou

		
	
      
        
          
        
      
    
        
            
         
    

   

	
		
			My Shows
		
		
		
		
			*Create a NEW SHOW or EDIT a current show by simply clicking the date within the month.
			Create »
		
	
	

                 
             
		 
			
			
			
			
			View Details >>
			
		
   
		
		
		
		
			View Details >>
	    
	
	
		
		
		
		
			View Details >>
	    
	

            

                
                        My Contacts
                
                
                  
                  
                  
                    
                      
                    
                  
                
            




    var loginUrl = &quot;https&amp;#58;&amp;#47;&amp;#47;cabiyou.stage.sumtotal.host&amp;#47;Broker&amp;#47;Token&amp;#47;generictokenhandler.ashx&quot;;
    var returnUrl = &quot;https&amp;#58;&amp;#47;&amp;#47;cabiyou.stage.sumtotal.host&amp;#47;core&amp;#47;&quot;;
    var userName = &quot;400000002&quot;;

    function openSumtotal() {
        authenticateSumtotalUser(loginUrl, returnUrl, userName)
    }


google.load(&quot;visualization&quot;, &quot;1&quot;, {packages:[&quot;corechart&quot;]});
google.setOnLoadCallback(drawChart);
var partyIdConsultant;
var dateList=new Array();
var backDateList=new Array();
var backDateArray=new Array();
var currentDateList=new Array();
var elligilbeShowDates=new Array();
var showDates= new Array();
var showIdListCurrent=new Array();
var showIdListFuture=new Array();
var showIdListBack=new Array();
var date='';
var indexFuture='';
var indexCurrent='';
var isBackDate=false;
var showDatesFuture=new Array();
var showDatesCurrent=new Array();
var showDatesBack=new Array();
var dateListShows='';
var flag=false;

function taskListBigSize(){
	$(&quot;.cross_btn&quot;).show();
	$(&quot;#task-list-content&quot;).css({&quot;width&quot;:&quot;70%&quot;});		
}
function taskList_close(){
	$(&quot;.cross_btn&quot;).hide();
	if($(&quot;#task-list-content&quot;).width()==1000)
	{$(&quot;#task-list-content&quot;).css({&quot;left&quot;:&quot;251px&quot;,&quot;position&quot;:&quot;absolute&quot;,&quot;width&quot;:&quot;70%&quot;,&quot;z-index&quot;:&quot;12&quot;});}	
	else
	{$(&quot;#task-list-content&quot;).css({&quot;left&quot;:&quot;0px&quot;,&quot;position&quot;:&quot;absolute&quot;,&quot;width&quot;:&quot;100%&quot;,&quot;z-index&quot;:&quot;12&quot;});}	
}

function isHashKey(evt) {
 var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode == 35) {
        return false;
    } else {
      return true;
    }
}
function sendLeftMenuGa(eventLabel) {
    ga('send', 'event', { eventCategory: 'BackOffice - MyDashboard - Left Menu', eventAction: 'link-click', eventLabel: eventLabel});
}

$( &quot;.todo-btn a&quot; ).on( &quot;click&quot;, function() {
     sendLeftMenuGa('Tasks');
});

$( &quot;.library-btn a&quot; ).on( &quot;click&quot;, function() {
     sendLeftMenuGa('Library');
});

$( &quot;.shows-btn a&quot; ).on( &quot;click&quot;, function() {
     sendLeftMenuGa('Shows');
});

$( &quot;.corporate-btn a&quot; ).on( &quot;click&quot;, function() {
     sendLeftMenuGa('eLearning');
});

$( &quot;.cabi-you a&quot; ).on( &quot;click&quot;, function() {
    sendLeftMenuGa('cabi-you');
});
function selectDateAndRedirectToShow(selectedDialogDate) {
        var dailogDate = selectedDialogDate;
        $(&quot;#showDetails > tbody&quot;).empty();
        var months = { 'January': '00',
                        'February': '01',
                        'March': '02',
                        'April': '03',
                        'May': '04',
                        'June': '05',
                        'July': '06',
                        'August': '07',
                        'September': '08',
                        'October': '09',
                        'November': '10',
                        'December': '11'
                    };
        var dailogMonth = months[$('.ui-datepicker-month').text()]
        //var color=$(this).css(&quot;background-color&quot;);
        dailogMonth=parseInt(dailogMonth)+1;
        var dailogYear=$('.ui-datepicker-year').text();
        var showIdListForConsultant='';
        var showLocationListForConsultant='';
        dailogMonth = (dailogMonth &lt; 10) ? '0' + dailogMonth : dailogMonth;
        dailogDate = (dailogDate &lt; 10) ? '0' + dailogDate : dailogDate;
        var date=dailogMonth+&quot;/&quot;+dailogDate+&quot;/&quot;+dailogYear;
        var currdate =$.datepicker.formatDate('yy-mm-dd',new Date(date));
        var  dd=$.datepicker.formatDate('mm/dd/yy',new Date(date));
        var showDatesforDailog=new Array();
        var showDatesforDailogCurr=new Array();
            var showDatesforDailogBack=new Array();
        var indexcrr;
        var indexall;
        // commenting the part ,earlier need to show popup for open shows,later chris sugessted it should open for closed shows.
        for (var i = 0; i &lt; dateList.length; i++) {
        showDatesforDailog[i]= $.datepicker.formatDate('mm/dd/yy', dateList[i]);
        }
        for (var i = 0; i &lt; currentDateList.length; i++) {
        showDatesforDailogCurr[i]= $.datepicker.formatDate('mm/dd/yy', currentDateList[i]);
        }
        for (var i = 0; i &lt; backDateArray.length; i++) {
        showDatesforDailogBack[i]= $.datepicker.formatDate('mm/dd/yy', backDateArray[i]);
        }
    
        indexall=   $.inArray(dd, showDatesforDailog);
        indexcrr= $.inArray(dd, showDatesforDailogCurr);
            indexback= $.inArray(dd, showDatesforDailogBack);
        //if(className=='hasDatepicker'){
        //className='';
        //return ;
        //}else 
        // code for on click of date will redirect to the create show screen
        var elligileDateForShow = elligilbeShowDates.indexOf($.datepicker.formatDate('mm/dd/y', new Date(date)).toString())
        if(indexall&lt;0 &amp;&amp; indexcrr&lt;0 &amp;&amp; indexback&lt;0 &amp;&amp; elligileDateForShow >= 0 ){
        
        var url='/backoffice/control/ShowCreateHostess?showId=&amp;dateOfShow='+dd;
        window.open(url,'','','')
        }
        
        
        if(indexall>=0 || indexcrr>=0 || indexback>=0){
        jQuery.ajax({
            url: '/retail/control/getShowIdListForConsultant',
            async: false,
            type: 'POST',
            data: {partyId: partyIdConsultant,month:dailogMonth,year:dailogYear,date:currdate},
            success: function (data) {
                showIdListForConsultant = data;
            }
        });
        jQuery.ajax({
            async: false,
            type: 'POST',
            url: '/retail/control/getLocationForShows?partyId='+partyIdConsultant+'&amp;showIdList='+showIdListForConsultant[0]+'',
            success: function (data) {
            showLocationListForConsultant = data;
            }
        });

        jQuery.each(showLocationListForConsultant, function(key, value) { 
        var url=&quot;/backoffice/control/ShowCreateHostess?showId=&quot;+key;
        var elementhtmlId=$('#listShowId').html();
        var elementhtmlHostess=$('#listShowHostess').html();
        elementhtmlHostess=elementhtmlHostess.replace('@@url@@',url).replace('@@value@@',value.hostessPartyName);
        elementhtmlId=elementhtmlId.replace('@@url@@',url).replace('@@value@@',key);
        var sqldate='';
        sqldate=value.showDate.split(&quot; &quot;);
    
        var datesplit='';
        var splitDate=''
        var datePopup='';
        var date=sqldate[0]
        datesplit=date.split(&quot;-&quot;);
        splitDate=sqldate[1];
        datePopup=splitDate.split(&quot;:&quot;);
        var timeDiff= Number(datePopup[0])-12;
        var time='';
        if (timeDiff > 0) {
            time = timeDiff +&quot;:&quot;+datePopup[1] + &quot; &quot;+ &quot;PM&quot;
        }  else if(timeDiff == 0) {
            time = &quot;12&quot; +&quot;:&quot;+datePopup[1]+ &quot; &quot;+ &quot;PM&quot;;
        }
        else if(timeDiff &lt; 0) {
            time = datePopup[0] +&quot;:&quot;+datePopup[1] +&quot; &quot;+ &quot;AM&quot;;
        }
         
        $('#showDetails').append('&lt;tr>&lt;td>&lt;p>'+datesplit[1]+&quot;/&quot;+datesplit[2]+&quot; &quot;+time+'&lt;/p>&lt;p>'+value.city+'&lt;/p>&lt;/td>&lt;td>&lt;p>'+elementhtmlHostess+'&lt;/p>&lt;p>'+value.state+'&lt;/p>&lt;/td>&lt;/tr>');
        });
        $(&quot;html,body&quot;).animate({scrollTop: window.pageYOffset}, 100);
        var offset = $(&quot;#calendar&quot;).offset();
        _top=offset.top+50;
        _left=offset.left+242;      
        $.colorbox({inline:true, href: '#popupnew',top:_top,left:_left, absolute: true});
        $('#cboxOverlay').css('display','none');        
        $(&quot;#wrapper&quot;).click(function(){
            jQuery.colorbox.close();
        });
    }
}
function renderSideBar(){
var taskValue='';
   setInterval(update, 1800000);
   update();
   var cd=new Date();
   
   jQuery.ajax({
        url: '/retail/control/getShowDatesForCalendar',
        async: false,
        type: 'POST',
        success: function (data) {
          jQuery.each(data, function(key, value) { 
          elligilbeShowDates.push(value)
           });
          
            }
    });
    
   jQuery.ajax({
        url: '/retail/control/getConsultantShowDetails',
        async: false,
        type: 'POST',
        data: {partyId: partyIdConsultant,month:cd.getMonth()+1,year:cd.getFullYear()},
        success: function (data) {
           dateListShows = data;
            }
    });
   jQuery.each(dateListShows, function(key, value) { 
   var date=value.date.date;
   var month=value.date.month+1;
   month = (month &lt; 10) ? '0' + month : month;
   var backDate=month+'/'+date+'/'+cd.getFullYear();
   var backDateObj=new Date(backDate);
   
    if(value.statusId=='CABI_SHOW_PLANNING'){
	   currentDateList.push(backDateObj);
	   showIdListCurrent.push(key);
    } else if(value.statusId=='CABI_SHOW_CLOSED' || value.statusId=='CABI_SHOW_SHIPPED'){
	    var showDates=new Array();
	 	for (var i = 0; i &lt; currentDateList.length; i++) {
	       showDates[i]= $.datepicker.formatDate('mm/dd/yy', currentDateList[i]);
	      }
	    var date=  $.datepicker.formatDate('mm/dd/yy',backDateObj);
	    var index=$.inArray(date, showDates);
	    if(index&lt;0) {
	     backDateList.push(backDateObj);
	     }
    }
     })
      for (var i = 0; i &lt; backDateList.length; i++) {
      var count =0;
      for (var j = 0; j &lt; currentDateList.length; j++) {
     if(currentDateList[j].toString() == backDateList[i].toString()) {
		count =parseInt(count)+1;
     }
      }
      if(count == 0) {
      backDateArray.push(backDateList[i]);
      }
      }
    var currentDate= new Date();

    $('#calendar').datepicker({ 
    currentText: &quot;Now&quot;,
    onChangeMonthYear: function(year, month,inst) { 
    jQuery.ajax({
        url: '/retail/control/getConsultantShowDetails',
        async: false,
        type: 'POST',
        data: {partyId: partyIdConsultant,month:month,year:year},
        success: function (data) {
           dateListShows = data;
            }
    });
     jQuery.each(dateListShows, function(key, value) { 
     var currDate= new Date();
   var date=value.date.date;
   var month=value.date.month+1;
   month = (month &lt; 10) ? '0' + month : month;
   var backDate=month+'/'+date+'/'+year;
   var backDateObj=new Date(backDate);
   if(value.statusId=='CABI_SHOW_PLANNING') {
   dateList.push(backDateObj);
   showIdListFuture.push(key);
   } else if(value.statusId=='CABI_SHOW_CLOSED' || value.statusId=='CABI_SHOW_SHIPPED'){
  	 for (var i = 0; i &lt; dateList.length; i++) {
       showDates[i]= $.datepicker.formatDate('mm/dd/yy', dateList[i]);
      }
	    var date=  $.datepicker.formatDate('mm/dd/yy',backDateObj);
	    var index=$.inArray(date, showDates);
	    if(index&lt;0) {
	      backDateList.push(backDateObj);
	     }
  
   }
     })
     for (var i = 0; i &lt; backDateList.length; i++) {
      var count =0;
      for (var j = 0; j &lt; dateList.length; j++) {
     if(dateList[j].toString() == backDateList[i].toString()) {
		count =parseInt(count)+1;
     }
      }
      if(count == 0) {
      backDateArray.push(backDateList[i]);
      }
      }
     
    },
      onSelect: function(dates) { 
      var showIdListForConsultant='';
      var selectedDate = $(this).datepicker(&quot;getDate&quot;);
      var currdate =$.datepicker.formatDate('mm/dd/yy',new Date(selectedDate));
      var selectedDialogDate = currdate.split('/')[1];
      selectDateAndRedirectToShow(selectedDialogDate);
      var cd=new Date(currdate);
      var today=new Date();
 
      jQuery.ajax({
        url: '/retail/control/getShowIdListForConsultant',
        async: false,
        type: 'POST',
        data: {partyId: partyIdConsultant,month:cd.getMonth()+1,year:cd.getFullYear(),date:currdate},
        success: function (data) {
           showIdListForConsultant = data;
            }
    });
      
    date=$.datepicker.formatDate('mm/dd/yy',new Date(dates));
     var cdate =$.datepicker.formatDate('mm/dd/yy',today)
    
     for (var i = 0; i &lt; dateList.length; i++) {
       showDatesFuture[i]= $.datepicker.formatDate('mm/dd/yy', dateList[i]);
      }
     
      for (var i = 0; i &lt; currentDateList.length; i++) {
       showDatesCurrent[i]= $.datepicker.formatDate('mm/dd/yy', currentDateList[i]);
      }
      for (var i = 0; i &lt; backDateArray.length; i++) {
       showDatesBack[i]= $.datepicker.formatDate('mm/dd/yy', backDateArray[i]);
      }
      
    indexFuture=   $.inArray(dates, showDatesFuture);
   var indexBack=  $.inArray(dates, showDatesBack);
  indexCurrent= $.inArray(dates, showDatesCurrent);
             var count1 = 0;
for (var p in showIdListForConsultant[0]) {
    if (showIdListForConsultant[0].hasOwnProperty(p)) {
        count1++;
    }
}
    if(dates&lt;cdate){
      flag=true
      }
      else if(indexBack>=0)
      {
        $('#createShow').removeClass('ui-state-disabled');
       return false;
       
      }
  else if(count1==0)
   {
     $('#createShow').removeClass('ui-state-disabled');
    if(indexCurrent>=0 || indexFuture>=0){
    }
    else {
     
       flag=true;
    }
    }
      },              
    beforeShowDay: highlightDays,
    })
    
   var className;
    $(&quot;#calendar&quot;).click(function(event) {
 className=  $(this).prop('class');
     });
}

function highlightDays(date) {
var nextMonthDate = '';
var currMonthDate = '';
var backMonthDate = ''
   for (var i = 0; i &lt; dateList.length; i++) {
            if (dateList[i].toString() == date.toString()) {              
               nextMonthDate = &quot;Y&quot;
               break;
            }
           }
           
           	
   for (var i = 0; i &lt; backDateArray.length; i++) {
            if (backDateArray[i].toString() == date.toString()) {              
                backMonthDate = &quot;Y&quot;
                break;
            }  
        }
    for (var i = 0; i &lt; currentDateList.length; i++) {
            if (currentDateList[i].toString() == date.toString()) {              
                currMonthDate = &quot;Y&quot;
                break;
            }  
        }
         if (elligilbeShowDates.indexOf($.datepicker.formatDate('mm/dd/y', date).toString()) >= 0 ) {
         if (nextMonthDate == &quot;Y&quot;) {
         return [true, 'highlight', null];
         } else if ( backMonthDate == &quot;Y&quot;) {
          return [true, 'highlightBack', null];
         } else if(currMonthDate == &quot;Y&quot;) {
          return [true, 'highlight', null];
         } else {
          return [true, ''];
         } 
         }else {
          return [false];
         }
        return [true, ''];
     } 
     
function generateTeamList(partyId) {
var teamMap='';
 jQuery.ajax({
        url: '/retail/control/getConsultantTeam',
        async: false,
        type: 'POST',
        data: {partyId: partyId},
        success: function (data) {
            teamMap = data; 
            }
    });
    
//var container  = document.getElementsByClassName('contacts-list module-list overview');
var container = $(&quot;#my-Team-list&quot;);
if(teamMap==null &amp;&amp; teamMap=='undefined')   {
		//var teamView  = document.getElementsByClassName('contacts-content scroll-pane');
		//var footer-id  = document.getElementsByClassName('smodule-footer');
		$(&quot;#scroll-pane-id&quot;).hide();
		$(&quot;#footer-id&quot;).hide();
    }
  /*data.addRows(Object.keys(salesMap).length);*/
  else{
  if(teamMap[&quot;teamMemberMap&quot;]){
  jQuery.each(teamMap[&quot;teamMemberMap&quot;], function(key, value) { 
  var url='/backoffice/control/ConsultantTeamDashBoard?partyId='+key;
  var elementhtml=$('#listTemplate').html();
  elementhtml=elementhtml.replace('@@url@@',url).replace('@@value@@',value);
  $($.parseHTML(elementhtml)).appendTo(container);  
     });
    }
     if(teamMap[&quot;teamOrphanMap&quot;]){
  jQuery.each(teamMap[&quot;teamOrphanMap&quot;], function(key, value) { 
  var url='/backoffice/control/ConsultantTeamDashBoard?partyId='+key;
  var elementhtml=$('#listTemplateOrphan').html();
  elementhtml=elementhtml.replace('@@url@@',url).replace('@@value@@',value);
  $($.parseHTML(elementhtml)).appendTo(container);  
     });
    } 
   }
}

 function update(){
   jQuery.ajax({
        url: '/retail/control/getPendingTasksForConsultant',
        async: true,
        type: 'POST',
        data: {partyId: partyIdConsultant},
        success: function (data) {
         if(data[0]>0){
      $('.overlay').show();
   $('.overlay').html(data[0])
   }
      else{
       $('.overlay').hide();
      }     
            }
    });
   
 
   }

function createShow(obj){
if(flag==true){
	var url='/backoffice/control/ShowCreateHostess?showId=&amp;dateOfShow='+date;
	$(obj).prop({&quot;href&quot;:url, &quot;target&quot;:&quot;_blank&quot;});
	} 
	else {
	var url='/backoffice/control/ShowCreateHostess';
	$(obj).prop({&quot;href&quot;:url, &quot;target&quot;:&quot;_blank&quot;});
	}
}
function teamListLoad(partyId){
	generateTeamList(partyId); 
}

function drawChart() {
var data=''
var party = '100000042' ;
 var salesInfo='';
 jQuery.ajax({
        url: '/retail/control/getConsultantSalesForCurrentAndPreviousSeason',
        async: false,
        type: 'POST',
        data: {partyId: party},
        success: function (data) {
            salesInfo = data;
            }
    });
var x1,y1,z1,x2,y2,z2;

if(!salesInfo[1] || salesInfo[1].gqv == undefined) {
x1=0;
y1=0;
z1=0;
} else {
x1=salesInfo[1].gqv;
y1=salesInfo[1].pqv;
z1=salesInfo[1].cv;
}
if(!salesInfo[0] || salesInfo[0].gqv == undefined) {
x2=0;
y2=0;
z2=0;
} else {
x2=salesInfo[0].gqv;
y2=salesInfo[0].pqv;
z2=salesInfo[0].cv;
}
     data = google.visualization.arrayToDataTable([
      ['Year', 'This Season', 'Last Season'],
      ['GQV',  x1,     x2],
      ['PQV',  y1,     y2],
      ['CV',  z1,      z2]
    ]);
     

   var options = {
           chartArea: {width:160,height:125},
           legend:{position: 'none'},
           series: [{color: '#ee4db7'} , {color: '#8c8c8d'}],
           vAxis: {format:'######'}
   };
   if(document.getElementById('cv-graph')){
    	var chart = new google.visualization.ColumnChart(document.getElementById('cv-graph'));
    	chart.draw(data, options);
    }
}

$(&quot;#contacts-search-box&quot;).keyup(function(event) {
    if( event.which == 13 ) {
    
    $(&quot;#contactSearchForm&quot;).submit();
    }
});

$(document).ready(function()
{      
     //teamListLoad('100000042');
    partyIdConsultant='100000042';
    $(&quot;.cross_btn&quot;).hide();
	/*Start Code for Dashboard will be visible on page load*/
	if(window.location.href.indexOf(&quot;/backoffice/control/main&quot;) > -1 || window.location.href.indexOf(&quot;/backoffice/control/login&quot;) > -1) {		
		teamListLoad('100000042');
		
		renderSideBar();
	 
		$('#sidebar').css({'display':'block','visibility':'visible'});
		$(&quot;.show-sidebar&quot;).css({&quot;display&quot;:&quot;none&quot;});
		$(&quot;.hide-sidebar&quot;).css({&quot;display&quot;:&quot;block&quot;});
		$(&quot;#sidebar-toggle&quot;).css({&quot;border-bottom-left-radius&quot;:&quot;0px&quot;,&quot;border-bottom-right-radius&quot;:&quot;0px&quot;});
		
		$(&quot;#container.internal-page&quot;).css({&quot;margin-top&quot;:&quot;0px&quot;});
		$(&quot;#sidebar-toggle&quot;).css({&quot;top&quot;:&quot;0px&quot;});
		$(&quot;.internal-page #sidebar&quot;).css({&quot;top&quot;:&quot;40px&quot;});
		$('#content-messages').css({&quot;float&quot;:&quot;right&quot;,&quot;width&quot;:&quot;728px&quot;});
		$('#sidebar-toggle').click(function() {
			sidebarToggle = $(this);	
			
			if(sidebarToggle.hasClass('active-toggle')){
				
				$(&quot;#sidebar-toggle&quot;).css({&quot;border-bottom-left-radius&quot;:&quot;0px&quot;,&quot;border-bottom-right-radius&quot;:&quot;0px&quot;});
				$('#sidebar').slideToggle('slow', function() {					
					// Animation complete.
					
						sidebarToggle.removeClass('active-toggle');						
						$(&quot;.hide-sidebar&quot;).css({&quot;background&quot;: &quot;url('/static/images/icon-double-arrow-up.png') 209px -1px no-repeat transparent&quot;,&quot;display&quot;:&quot;block&quot;});
				   });
						$('#content-messages').css({&quot;float&quot;:&quot;right&quot;,&quot;width&quot;:&quot;728px&quot;});
				}
				else{					
					$('#sidebar').slideToggle('slow', function() {					
						// Animation complete.
							sidebarToggle.addClass('active-toggle');
							$(&quot;#sidebar-toggle&quot;).css({&quot;border-bottom-left-radius&quot;:&quot;15px&quot;,&quot;border-bottom-right-radius&quot;:&quot;15px&quot;});		
							$(&quot;.hide-sidebar&quot;).css({&quot;background&quot;: &quot;url('/static/images/icon-double-arrow-down.png') 209px -1px no-repeat transparent&quot;,&quot;display&quot;:&quot;block&quot;});						
						});
				    $('#content-messages').css({&quot;float&quot;:&quot;none&quot;,&quot;width&quot;:&quot;980px&quot;});
				}
			});	
            // Bar graphs for pending RMA's widget.
            jQuery('.bar-chart li .bar span').each(function(i) {
            jQuery(this).delay((i++) * 100).animate({width: jQuery(this).attr(&quot;rel&quot;)+&quot;%&quot;});
        })
	}
	/*End Code for Dashboard will be visible on page load*/
	else{
		$(&quot;#cv-graph&quot;).css({&quot;margin&quot;:&quot;0 0 0 -66px&quot;})
		$('#sidebar-toggle').click(function() {
			sidebarToggle = $(this);
			
			
			if(sidebarToggle.hasClass('active-toggle')){
				$('#sidebar').slideToggle('slow', function() {
					// Animation complete.
					sidebarToggle.removeClass('active-toggle');
				});
			}else{
			teamListLoad('100000042');
			//$(&quot;.scroll-pane&quot;).tinyscrollbar({ sizethumb: 35 }); 
			 renderSideBar();
			 
				$('#sidebar').css({'display':'none','visibility':'visible'});
				sidebarToggle.addClass('active-toggle');
				$('#sidebar').slideToggle('slow');
			}
		});
	}
var customerLookup =new NonHostessLookup()
});
$(&quot;.colorbox_crossbtn&quot;).click(function() {
    $.colorbox.close();
})

function openLibrary(externalLoginKey) {
	var url = &quot;https://cabilibrary.cabiclio.com/wp-admin/admin-ajax.php?action=library_sso_login&amp;externalLoginKey=&quot; + externalLoginKey + &quot;&amp;referrer=&quot; + encodeURIComponent('https://test14.cliotest.com');
	window.open(url,'Popup');

	}

var NonHostessLookup = function(){
    var cobj = this	
	this.enabled=true
   
	this.lookupConfig={
	   minLength:3,
	   source:function( request, response ){	       
	   		if(!cobj.enabled) {return}
	   		  
	   		var serviceUrl;
	   		  
	   		//var partyId = 'CABI'
			//
				orderLookupText = &quot;0&quot;;	    
	   		  	serviceUrl = '/retail/control/lookupGuest?term='+request.term+'&amp;partyId='+partyIdConsultant;
				
	    	  $.getJSON(serviceUrl , function(data) {
	    			var suggestions = [];
	    			$.each(data.search_result, function(i, item){
                        if( item.lastName == null ||  item.lastName ==  undefined) {
                            lastName = '-'
                        } else {
                            lastName = item.lastName
                        }
                        suggestions.push({ id: item.partyId, label: item.firstName+' '+lastName, value: item.firstName+' '+item.lastName })
					})
			
					if(suggestions.length==0){
						suggestions.push({ label: 'No results found', value:null });
			   	  	}
			   	    	
			   	    response(suggestions);
	   	      })
	   	   },
	   	   select:function(e, ui) {			   	
			   var partyId = ui.item.id
			   if(!partyId){
				   return;
		   	   }
		   	   ui.item.value=ui.item.label
		   	   orderLookupTextName=ui.item.label
		       orderLookupText = partyId;
		       $('#partyId').val(partyId);
		       
		       $('#contactSearchForm').prop('action', 'ViewCustomerProfile?owningPartyId='+partyIdConsultant); 
			   $('#contactSearchForm').submit();
			},
	}
	
	$('#contacts-search-box').autocomplete(this.lookupConfig);
	$('#contacts-search-box').autocomplete('widget').css('z-index', 100);
}	

	

                
		                             
			


var errorHanlder = null;
var messageHandler = null;
$(document).ready(function() {
    errorHanlder = new ErrorHanlder();
    errorHanlder.checkFormError();
    messageHandler = errorHanlder;
});
   
   
  function ErrorHanlder(){
  	  this.debug=true;
	  
	  this.getErrorList=function(){	  
	     var ret = [
	    ]
	    return ret;	  
	  }
	  
	  
	  this.getFormErrorList=function(){	 
	    var erList = this.getErrorList() 
	     var ret =  []
		   for (i=0;i&lt;erList.length;i++){
				var msgDeatail = erList[i]
				var str = msgDeatail.split('~')
				if(str.length==1){ str = ['','',str[0]] }
				else if(str.length==2){ str = ['',str[0],str[1]] }
				else{ str = [str[0],str[1],str[2]] }
				
				var formName = str[0]
				var fieldName= str[1]
				var msg =str[2]
				var msgInfo = {msg:str[2]}
				if(str[0]!='') msgInfo['formName']=str[0]
				if(str[1]!='') msgInfo['fieldName']=str[1]
				ret.push(msgInfo)
		   }
	    return ret;	  
	  }
	  
	  
	  this.checkFormError=function(){
	   var formErrorList = this.getFormErrorList()
	  	for(var i=0;i&lt;formErrorList.length;i++){
	  	  this.renderFormError(formErrorList[i])
	  	}
	  }
	  
	  this.renderFormError=function(errorInfo){ 
	  	var formName = errorInfo.formName
	  	var fieldName = errorInfo.fieldName
	  	var erMsg = errorInfo.msg
	  	if(!fieldName){
	  		//render into header section
	  		var msgContent = &quot;ERROR: &quot;+erMsg
	  		$('#global_error_msg_container').html(msgContent)
	  		$('#global_error_msg_container').show()
	  		return;
	  	
	  	} 
	  	
	    var errorContainerId = &quot;#error_&quot;+fieldName
	    var errorContainer=null;
	  	if(formName!=undefined){
	  	    var container = $(&quot;form[name='&quot;+formName+&quot;'] &quot;+errorContainerId)
	  	    if(container.length==0) { //No specific container added, simply render error into parent of specified field  
	  	     	container =  $(&quot;form[name='&quot;+formName+&quot;'] input[name='&quot;+fieldName+&quot;']&quot;).parent()
	  	     	if(container.length==0) container =  $(&quot;form[name='&quot;+formName+&quot;'] select[name='&quot;+fieldName+&quot;']&quot;).parent()
	  	     	if(container.length==0) container =  $(&quot;form[name='&quot;+formName+&quot;'] checkbox[name='&quot;+fieldName+&quot;']&quot;).parent()
	  	     	
	  	     	if(container.length==0 &amp;&amp; this.debug) {alert('Could not found container for field:'+fieldName+&quot; form:&quot;+formName)}
	  	    }
	  	    errorContainer = container 
	  	}else{
	  		var container = $(errorContainerId)
	  		if(container.length==0){ //No specific container added, simply render error into parent of specified field
	  			container =  $(&quot;input[name='&quot;+fieldName+&quot;']&quot;).parent()
	  		}
	  		
	  		if(container.length==0 &amp;&amp; this.debug) {alert('Could not found container for field:'+fieldName)}
	  		errorContainer = container
	  	}
	  	var errorHTML = &quot;&lt;span class='form-field-error-display' style='color:red;'>&quot;+erMsg+&quot;&lt;/span>&quot;
	  	$(errorHTML).appendTo(errorContainer)
	  	if(errorContainer){errorContainer.show()}
	  }
	 
    this.msgDialog = function(msg, title) {
        if (!title) title = &quot;Message&quot;;
        $('#cabi-dialog-message').attr(&quot;title&quot;, title);
        $('#dialog_msg_content').html(msg);
        $('#dialog_msg_section').show();
        $('#dialog_error_section').hide();
        this.openDialog();
    };

    this.errDialog = function(msg,title) {
        if(!title) title = &quot;Error&quot;;
        $('#cabi-dialog-message').attr(&quot;title&quot;, title);
        $('#dialog_eror_content').html(msg);
        $('#dialog_error_section').show();
        $('#dialog_msg_section').hide();
        this.openDialog();
    };

    this.openDialog = function() {
        var focused = $(':focus');
        $(&quot;#cabi-dialog-message&quot;).dialog({
            modal: true,
            buttons: {Ok: function() {$(this).dialog(&quot;close&quot;); $(focused).focus();}}
        });
    };
  }



    
        
        
    
    
        
    





		   






$('.error-message').first().remove()
$('.dashboard-module-errormessage').first().remove()  
$('.module-normal-message-success').first().remove()

function CheckoutController(){
	var _self = this
    this.containerId='#checkout_tab_container'
    this.tabUrlMap = {
		'order_items':'viewCart',
		'shipping':'checkoutshippingaddress',
		'payment':'paymentoptions',
		'review':'confirmOrder'
	} 
	this.default_tab='order_items'
	this.loadingSection = '#checkout_screen_content_wrapper'
	this.overrideLoadingSection='#checkout-content'
	this.useCartSummaryParentForLoading=false;
	this.cartSummrySection='#cart-summary-section'
 	   
	
	this.init=function(loadDefualtTab){
		//set actions..
		if(loadDefualtTab){
			this.loadDefaultTab();
		}
		
		//Disable caching
		$.ajaxSetup({ cache: false });
	}
	this.loadDefaultTab=function(){
	    var tabName = ''
    	var params=getSearchParams()
    	if(params &amp;&amp; params['_tab']){
    		tabName = params['_tab'];
    	}
    	 
	    this.loadTab(tabName,params)
	}
	
	this.loadTab = function(tab, param){
		var url = this.tabUrlMap[tab]
		if(!url){
			url = this.tabUrlMap[this.default_tab]
		 }
		url = '/retail/control/'+url+''
		
		if(!param &amp;&amp; tab=='customer_info'){
			param = {}
			
			
			
		}
		
		this.loadTabByUrl(url,param)
	}
	
	this.loadTabByUrl = function(url, param, freezLocation){
		$('.error-message').remove()
		this.showLoading()
		if(!freezLocation){
			appendSearchParmsToUrl(param,url)
		}
		$(this.containerId).load(url,param, function(){})
	}
	
	this.showLoading= function(){
		if($('#loading_div').length>0){
			if($('#loading_div').is(&quot;:visible&quot;)){
				//there is already a loading indicator running
				return;
			}
			$('#loading_div').remove()
		}
		var LoadingHtml ='&lt;div id=&quot;loading_div&quot; style=&quot;width:100%;text-align:center;&quot;>&lt;br/>&lt;br/>&lt;br/>&lt;br/>';
		LoadingHtml+='&lt;img src=&quot;https://test14.cliotest.com/static/images/ajax-loader_small.gif&quot; />&lt;span>&lt;br/>Loading...&lt;/span>&lt;/div>';
		
		var targetDiv = null	
		var pushContent = null
		if(this.overrideLoadingSection &amp;&amp; $(this.overrideLoadingSection).length>0){
			targetDiv = $(this.overrideLoadingSection)
		}
		
		if((!targetDiv || targetDiv.length==0) &amp;&amp; this.useCartSummaryParentForLoading){
			targetDiv = $(this.cartSummrySection).parent()
			pushContent = $(this.cartSummrySection)
		}
		
		if(!targetDiv || targetDiv.length==0){
			targetDiv= $(this.loadingSection)
		}
		
		if(!targetDiv || targetDiv.length==0){
			targetDiv= $(this.containerId)
		}
		targetDiv.html('')
		if(pushContent &amp;&amp; pushContent.length >0){
			pushContent.appendTo(targetDiv)
		}
		$(LoadingHtml).appendTo(targetDiv)
		if($(window).scrollTop() >420){
			window.scrollTo(0, 0)
		}
	}
	
	this.setAjaxAction=function(hrefSel){
		$.each($(hrefSel), function(){
			var rel= $(this).prop('rel')
			if(!(rel &amp;&amp; rel.length>0)){
				$(this).prop('rel', $(this).prop('href'));
				$(this).prop('href', 'javascript:void(0)');
			}
		})
		
		$(hrefSel).bind('click', function(){
			_self.loadTabByUrl($(this).prop('rel'))
		})
	}
}

function startCheckout(){
	checkoutController.loadTabByUrl('/retail/control/checkoutoptions')
}

$(window).bind('popstate', function(event) {
 checkoutController.loadTabByUrl(document.location.href, {},true)
});



var checkoutController = null
$(document).ready(function(){
	checkoutController = new CheckoutController()
	checkoutController.tabUrlMap['customer_info']='confirmRecipient'
	checkoutController.tabUrlMap['order_items']='browseCategory'
	checkoutController.default_tab='customer_info'
	checkoutController.init(false)
});






var errorHanlder = null;
var messageHandler = null;
$(document).ready(function() {
    errorHanlder = new ErrorHanlder();
    errorHanlder.checkFormError();
    messageHandler = errorHanlder;
});
   
   
  function ErrorHanlder(){
  	  this.debug=true;
	  
	  this.getErrorList=function(){	  
	     var ret = [
	    ]
	    return ret;	  
	  }
	  
	  
	  this.getFormErrorList=function(){	 
	    var erList = this.getErrorList() 
	     var ret =  []
		   for (i=0;i&lt;erList.length;i++){
				var msgDeatail = erList[i]
				var str = msgDeatail.split('~')
				if(str.length==1){ str = ['','',str[0]] }
				else if(str.length==2){ str = ['',str[0],str[1]] }
				else{ str = [str[0],str[1],str[2]] }
				
				var formName = str[0]
				var fieldName= str[1]
				var msg =str[2]
				var msgInfo = {msg:str[2]}
				if(str[0]!='') msgInfo['formName']=str[0]
				if(str[1]!='') msgInfo['fieldName']=str[1]
				ret.push(msgInfo)
		   }
	    return ret;	  
	  }
	  
	  
	  this.checkFormError=function(){
	   var formErrorList = this.getFormErrorList()
	  	for(var i=0;i&lt;formErrorList.length;i++){
	  	  this.renderFormError(formErrorList[i])
	  	}
	  }
	  
	  this.renderFormError=function(errorInfo){ 
	  	var formName = errorInfo.formName
	  	var fieldName = errorInfo.fieldName
	  	var erMsg = errorInfo.msg
	  	if(!fieldName){
	  		//render into header section
	  		var msgContent = &quot;ERROR: &quot;+erMsg
	  		$('#global_error_msg_container').html(msgContent)
	  		$('#global_error_msg_container').show()
	  		return;
	  	
	  	} 
	  	
	    var errorContainerId = &quot;#error_&quot;+fieldName
	    var errorContainer=null;
	  	if(formName!=undefined){
	  	    var container = $(&quot;form[name='&quot;+formName+&quot;'] &quot;+errorContainerId)
	  	    if(container.length==0) { //No specific container added, simply render error into parent of specified field  
	  	     	container =  $(&quot;form[name='&quot;+formName+&quot;'] input[name='&quot;+fieldName+&quot;']&quot;).parent()
	  	     	if(container.length==0) container =  $(&quot;form[name='&quot;+formName+&quot;'] select[name='&quot;+fieldName+&quot;']&quot;).parent()
	  	     	if(container.length==0) container =  $(&quot;form[name='&quot;+formName+&quot;'] checkbox[name='&quot;+fieldName+&quot;']&quot;).parent()
	  	     	
	  	     	if(container.length==0 &amp;&amp; this.debug) {alert('Could not found container for field:'+fieldName+&quot; form:&quot;+formName)}
	  	    }
	  	    errorContainer = container 
	  	}else{
	  		var container = $(errorContainerId)
	  		if(container.length==0){ //No specific container added, simply render error into parent of specified field
	  			container =  $(&quot;input[name='&quot;+fieldName+&quot;']&quot;).parent()
	  		}
	  		
	  		if(container.length==0 &amp;&amp; this.debug) {alert('Could not found container for field:'+fieldName)}
	  		errorContainer = container
	  	}
	  	var errorHTML = &quot;&lt;span class='form-field-error-display' style='color:red;'>&quot;+erMsg+&quot;&lt;/span>&quot;
	  	$(errorHTML).appendTo(errorContainer)
	  	if(errorContainer){errorContainer.show()}
	  }
	 
    this.msgDialog = function(msg, title) {
        if (!title) title = &quot;Message&quot;;
        $('#cabi-dialog-message').attr(&quot;title&quot;, title);
        $('#dialog_msg_content').html(msg);
        $('#dialog_msg_section').show();
        $('#dialog_error_section').hide();
        this.openDialog();
    };

    this.errDialog = function(msg,title) {
        if(!title) title = &quot;Error&quot;;
        $('#cabi-dialog-message').attr(&quot;title&quot;, title);
        $('#dialog_eror_content').html(msg);
        $('#dialog_error_section').show();
        $('#dialog_msg_section').hide();
        this.openDialog();
    };

    this.openDialog = function() {
        var focused = $(':focus');
        $(&quot;#cabi-dialog-message&quot;).dialog({
            modal: true,
            buttons: {Ok: function() {$(this).dialog(&quot;close&quot;); $(focused).focus();}}
        });
    };
  }



    
        
        
    
    
        
    








	Retail Store	

 

	





				1Guests Information
	
			2Order Items
	
			3Shipping			
	
			4Payments
	
			5Verify &amp; Submit
		
		
	
		6Confirmation


	
	var loadOnStartup = 'true';
	var viewIndex = 1;
	$(document).ready(function(){
		// Open/Close note panel
		$(&quot;.view-notes&quot;).toggle(function() {
			$(this).removeClass(&quot;btn-stl-pk&quot;);
			$(this).addClass(&quot;btn-stl-wh&quot;);
			$(this).children(&quot;i&quot;).removeClass(&quot;fa-angle-down&quot;);
			$(this).children(&quot;i&quot;).addClass(&quot;fa-angle-up&quot;);
			$(this).html('Hide Notes &lt;i class=&quot;fa fa-angle-up&quot; aria-hidden=&quot;true&quot;>&lt;/i>');
			if(loadOnStartup == &quot;true&quot;) { displayNotesSection(); }
			$( &quot;#notes_content&quot; ).slideDown( &quot;slow&quot;);
		}, function() {
			$(this).removeClass(&quot;btn-stl-wh&quot;);
			$(this).addClass(&quot;btn-stl-pk&quot;);
			$(this).children(&quot;i&quot;).removeClass(&quot;fa-angle-up&quot;);
			$(this).children(&quot;i&quot;).addClass(&quot;fa-angle-down&quot;);
			$(this).html('View Notes &lt;i class=&quot;fa fa-angle-down&quot; aria-hidden=&quot;true&quot;>&lt;/i>');
			$( &quot;#notes_content&quot; ).slideUp( &quot;slow&quot;);
		});
		
		// Add new note
		$(&quot;.add-note&quot;).click(function() {
			if ($(&quot;#notes&quot;).hasClass( &quot;mode-view&quot; )) {
				note_form(&quot;.note-list&quot;,&quot;&quot;,&quot;&quot;,&quot;&quot;);
				disabled_note();
			}
		});
		
		// Cancel new note
		$(document).on('click', '.cancel-note', function (e) {
			var target = $(this).closest(&quot;.note&quot;);
			var note_date = target.find(&quot;.date_orig&quot;).text();
			var note_text = target.find(&quot;.content_orig&quot;).text();
			var noteId = target.attr(&quot;id&quot;);
			var noteName = target.find(&quot;.noteName_orig&quot;).text();
			var referenceId = target.find(&quot;.referenceId_orig&quot;).text();
			if (note_date) {
				create_note(target,note_date,note_text,noteId,noteName,referenceId);
			} else {
				target.remove();
			}
			enable_note();
		});
		
		// Edit note
		$(document).on('click', '.edit-note', function (e) {
			if ($(&quot;#notes&quot;).hasClass( &quot;mode-view&quot; )) {
				var target = $(this).closest(&quot;.note&quot;);
				var date = target.find(&quot;.date&quot;).text();
				var content = target.find(&quot;.content&quot;).text();
				var noteId = target.attr(&quot;id&quot;);
				var noteName = target.find(&quot;.notes-type-header&quot;).attr(&quot;data-type&quot;);
				var referenceId = target.find(&quot;.notes-type-content&quot;).text();
				disabled_note();
				note_form(target, date, content, noteId, noteName, referenceId);
			}
		});
		
		//Handle Hostess/CoHostess dropdown
		$(document).on('change', '.showNotes-dropdown', function (e) {
			$(&quot;#selectedPartyId&quot;).val($('.showNotes-dropdown').val());
			$( &quot;.note-list&quot; ).empty();
			viewIndex = 1;
			displayNotesSection();
			enable_note();
		});
	});
	
	//Load More notes
	function loadMoreNotes(obj) {
		displayNotesSection();
	}
	
	//Save Note
	function save_note(obj) {
		var target = $(obj).closest(&quot;.note&quot;);
		var note_date = target.find(&quot;.date_orig&quot;).text();
		var note_text = target.find(&quot;textarea&quot;).val();
		var noteId = target.attr(&quot;id&quot;);
		if (note_text.trim().length == 0) {
			$(&quot;.cancel-note&quot;).click();
		} else {
			saveNote(note_text, noteId);
		}
		enable_note();
	}
	
	//Delete Note
	function delete_note(obj) {
		if ($(&quot;#notes&quot;).hasClass( &quot;mode-view&quot; )) {
			var target = $(obj).closest(&quot;.note&quot;);
			var noteId = target.attr(&quot;id&quot;);
			$(this).closest(&quot;.note&quot;).remove();
			deleteNote(noteId);
		}	
	}

    function enable_note() {
        $(&quot;#notes&quot;).addClass(&quot;mode-view&quot;);
        $(&quot;#notes&quot;).removeClass(&quot;mode-edit&quot;);
    }

    function disabled_note() {
        $(&quot;#notes&quot;).removeClass(&quot;mode-view&quot;);
        $(&quot;#notes&quot;).addClass(&quot;mode-edit&quot;);
    }

    function create_note(target,date,content,noteId,noteName,referenceId) {
        var noteType;
        if(noteName == &quot;CABI_ORDER_NOTE&quot;) {
            noteType = &quot;&lt;span class='notes-type-header' data-type='CABI_ORDER_NOTE'>Order:&lt;/span>&amp;nbsp;&amp;nbsp;&lt;a class='notes-type-content' target='_blank' href='/backoffice/control/orderview?externalLoginKey=EL502799607534&amp;orderId=&quot; + referenceId + &quot;&amp;orderLookup=true'>&quot; + referenceId + &quot;&lt;/a>&quot;;
        } else if(noteName == &quot;CABI_SHOW_NOTE&quot;) {
            noteType = &quot;&lt;span class='notes-type-header' data-type='CABI_SHOW_NOTE'>Show:&lt;/span>&amp;nbsp;&amp;nbsp;&lt;a class='notes-type-content' target='_blank' href='/backoffice/control/ShowOverview?externalLoginKey=EL502799607534&amp;showId=&quot; + referenceId + &quot;'>&quot; + referenceId + &quot;&lt;/a>&quot;;
        } else {
            noteType = &quot;&lt;span class='notes-type-header' data-type='CABI_GENERAL_NOTE'>&lt;/span>&quot;;
        }
        var html = ` &lt;div class=&quot;note&quot; id=&quot;`+noteId+`&quot;>&lt;div class=&quot;controls&quot;>&lt;a class=&quot;control edit-note&quot;>&lt;i class=&quot;fa fa-pencil-square-o&quot; aria-hidden=&quot;true&quot;>&lt;/i>&lt;/a>&lt;a class=&quot;control destory-note&quot; style=&quot;pointer:cursor&quot; onclick=&quot;delete_note(this);&quot;>&lt;i class=&quot;fa fa-times-circle&quot; aria-hidden=&quot;true&quot;>&lt;/i>&lt;/a>&lt;/div>&lt;span class=&quot;date&quot;>`+date+`&lt;/span>&lt;div class=&quot;content&quot;>`+content+`&lt;/div>`+noteType+`&lt;/div>`;

        if (target == &quot;.note-list&quot;) {
            jQuery(target).append(html);
        } else {
            jQuery(target).replaceWith(html);
        }
    }
		
	function note_form(target,date,content,noteId,noteName,referenceId) {
			var html = `&lt;div class=&quot;note note_form&quot; id=&quot;`+noteId+`&quot;>
							&lt;textarea>`+content+`&lt;/textarea>
							&lt;div class=&quot;hide date_orig&quot;>`+date+`&lt;/div>
							&lt;div class=&quot;hide content_orig&quot;>`+content+`&lt;/div>
							&lt;div class=&quot;hide noteName_orig&quot;>`+noteName+`&lt;/div>
							&lt;div class=&quot;hide referenceId_orig&quot;>`+referenceId+`&lt;/div>
							&lt;div class=&quot;notes-button&quot;>
								&lt;a class=&quot;section-btn btn-stl-wh cancel-note&quot;>Cancel&lt;/a>
								&lt;a class=&quot;section-btn btn-stl-pk save-note&quot; style=&quot;pointer:cursor;&quot; onclick=&quot;save_note(this)&quot;>Save&lt;/a>
							&lt;/div>
						&lt;/div>`;
			if (target == &quot;.note-list&quot;) {
				jQuery(target).prepend(html);
			} else {
				jQuery(target).replaceWith(html);
			}
		}
		
	//Display Notes
	function displayNotesSection(){
		$(&quot;#notes&quot;).block({ 
       		message: '&lt;img src=&quot;/static/images/dynamicLoader.gif&quot; />' ,
        	css: { border: '0px',backgroundColor:'transparent'},overlayCSS:{ backgroundColor: '#FFF',opacity:.3} 
    	});
		$.ajax({
	       	method: &quot;POST&quot;,
		    url: &quot;/retail/control/viewNotes&quot;,
		    data: { 
			    partyId: $(&quot;#selectedPartyId&quot;).val(),
		        showId: $(&quot;#showId&quot;).val(),
		        orderId: $(&quot;#orderId&quot;).val(),
		        viewIndex: viewIndex
		    }, 
		    success: function(response) {
		        	if(response.result.notes != &quot;&quot;) {
			        	$.each(response.result.notes, function(index, note) {
		                	create_note(&quot;.note-list&quot;, note.noteDateTime, note.noteInfo, note.noteId, note.noteName, note.referenceId);
		           		});
		           		++viewIndex;
		        		loadOnStartup = 'false';
		        		$(&quot;.load-section&quot;).html('&lt;a class=&quot;load-more&quot; style=&quot;cursor:pointer&quot; onclick=loadMoreNotes(this);>&lt;i class=&quot;fa fa-angle-down&quot; aria-hidden=&quot;true&quot;>&lt;/i>Load More&lt;i class=&quot;fa fa-angle-down&quot; aria-hidden=&quot;true&quot;>&lt;/i>&lt;/a>');
		        	}else{
		        		$(&quot;.load-section&quot;).html(&quot;&quot;);
		        	}
		        },
		    complete: function() {
		    	$(&quot;#notes&quot;).unblock();
		    }
	    });  
	}	
		
	//Create new note
	function saveNote(note_text, noteId){
		$(&quot;#notes&quot;).block({ 
	     	message: '&lt;img src=&quot;/static/images/dynamicLoader.gif&quot; />' ,
	       	css: { border: '0px',backgroundColor:'transparent'},overlayCSS:{ backgroundColor: '#FFF',opacity:.3} 
	   	});
		$.ajax({
	       	method: &quot;POST&quot;,
		    url: &quot;/retail/control/createUpdateNote&quot;,
		    data: { 
		    	partyId: $(&quot;#selectedPartyId&quot;).val(),
	 	       	showId: $(&quot;#showId&quot;).val(),
	    	    orderId: $(&quot;#orderId&quot;).val(),
		        noteInfo: note_text,
		        noteId: noteId
		    }, 
		    success: function(response) {
		    	viewIndex = 1;
		    	$( &quot;.note-list&quot; ).empty();
		    	displayNotesSection();
		    },
		    complete: function() {
	    		$(&quot;#notes&quot;).unblock();
	    	}
	    });
	}
	
	//Delete Note
	function deleteNote(noteId) {
		$(&quot;#notes&quot;).block({ 
	     	message: '&lt;img src=&quot;/static/images/dynamicLoader.gif&quot; />' ,
	       	css: { border: '0px',backgroundColor:'transparent'},overlayCSS:{ backgroundColor: '#FFF',opacity:.3} 
	   	});
		$.ajax({
	       	method: &quot;POST&quot;,
		    url: &quot;/retail/control/deleteNote&quot;,
		    data: { 
		        noteId: noteId
		    }, 
		    success: function(response) {
		    	viewIndex = 1;
		    	$( &quot;.note-list&quot; ).empty();
		    	displayNotesSection();
		    },
		    complete: function() {
	    		$(&quot;#notes&quot;).unblock();
	    	}
	    });
	}
	

	
		
			
				View Notes 
			
		
		
			
				
					
					 Note
				
							
				
					
				
				Load More
			
		
	
 

$(document).ready(function(){
	if(window.checkoutController !=undefined){
		checkoutController.setAjaxAction('a.checkout-tab')
		$('a.checkout-tab').bind('click', function(){
			$('a.checkout-tab').unbind()
			$('li.enabled').addClass('visited')
			$('li.enabled').removeClass('enabled')
			$(this).parent().addClass('enabled')
		})
	}
})





	
	 
	
		

    
    
	


.ui-autocomplete-loading { background: url(&quot;/static/images/ajax-loader_small.gif&quot;) no-repeat scroll 222px 6px #FFFFFF !important;}




		
			This purchase order is for
		
		
		
			
				
					
						
						Existing Customer
						
					

					
						
							New Customer
					
			
		

		








.input-label{min-width:90px}
.not-active {
    pointer-events: none;
    cursor: default;
}




var errMsg = 'We are unable to reach our shipping services provider. Please try later.';
var invalidMsg = 'Could not validate address. Please make sure the address is correct.';
function AddressValidator(){
	var _self = this;
	
	//TODO get it from UI labels
    this.invalidErMesg=invalidMsg;
	this.validateMessage='Address validated by cabi.';
    this.errorMessage= errMsg;
	
	this.cfg={
	       id : 'address',
		   toNameField:&quot;#toName&quot;,
		   add1Field:&quot;#address1&quot;,
		   add2Field:&quot;#address2&quot;,
		   cityField:&quot;#city&quot;,
		   stateField:&quot;#stateProvinceGeoId&quot;,
		   zipField:&quot;#postalCode&quot;,
		   validatedFlagField:'#addressValidated', 
		   indicatorPanel:'li#addValidIndicator',
		   hintIndicatorPanel: &quot;#hintlabel&quot;,
		   formName:'nonameaddressform',
           buttonSection:'#addressValidationSection'
	   }
	   
	//check string to insure whether the address has been changed or not
	//Format add1-add2-city-state-zip
	this.initialCheckValue = &quot;&quot;;
	this.initialToName=null
    this.originalAddress=null;
	this.validationResult=null; //{ result:status/not_found, checkValue, ignore:true/false, matches:[] }
	this.isValidAddress = null;
    this.validateOnClick = false;
	this.validateOnLoad=true
	this.init=function(cfg){
		if(cfg){
			//Extend configurations
			$.extend(this.cfg, cfg);
		}
		
        //Update checkValue for future comparisons
		this.initialCheckValue=this.getCurrentCheckValue();
		
		if($(this.cfg.toNameField).length>0){
			this.initialToName=$(this.cfg.toNameField).val();
		}
		$(this.cfg.zipField).bind('blur', function(){
            $(_self.cfg.buttonSection).hide();
			if($(_self.cfg.add1Field).val() =='' || $(_self.cfg.cityField).val() =='') {
				_self.validateAddress(true);
			} else {
				_self.validateAddress(false);
			}
		});
		if(this.initialCheckValue.length >6){
			if(this.validateOnLoad){
				this.validateAddress(true);
			}else{
				this.validationResult={};
			}
		}	
		
		$(this.cfg.add1Field).bind('change',function(){$(_self.cfg.buttonSection).hide(); _self.backgroundValidate(this);});
		$(this.cfg.add2Field).bind('change',function(){$(_self.cfg.buttonSection).hide(); _self.backgroundValidate(this);});
		$(this.cfg.cityField).bind('change',function(){$(_self.cfg.buttonSection).hide(); _self.backgroundValidate(this);});
		$(this.cfg.stateField).bind('change',function(){
			if($(_self.cfg.add1Field).val() =='' || $(_self.cfg.cityField).val() =='' || $(_self.cfg.zipField).val() =='')  {
				 	return;
			}
            $(_self.cfg.buttonSection).hide();
            _self.validateAddress(false);
		});
	}
	
	this.backgroundValidate=function(obj){
	    var checkValue = this.getCurrentCheckValue()
	    if(this.validationResult!=null &amp;&amp; checkValue.length >6){
			this.validateAddress(true);
		}	
	}
	
	this.reset = function(){
	   if($(this.cfg.zipField).val().length == 0 ){
	       this.validationResult = null;
       }
	   this.initialCheckValue = this.getCurrentCheckValue();
	   $(this.cfg.indicatorPanel).html('');
	   this.backgroundValidate();
	}
	
	this.isModified=function(){
	   var currentCheckValue = this.getCurrentCheckValue()
	   var addressModieid =  this.initialCheckValue!=currentCheckValue
	   if(!addressModieid &amp;&amp; this.initialToName){
	   		return this.initialToName !=$(this.cfg.toNameField).val()
	   }
	   
	   return addressModieid
	}
	
	this.isValidated=function(){
		var currentCheckValue = this.getCurrentCheckValue();
		if(this.validationResult &amp;&amp; this.validationResult.checkValue==currentCheckValue){
			return true
		}
		return false
		
	}
	
    this.isAddressValid = function(){
       return this.isValidAddress;
    }
	
	this.validateAddress=function(noHint){
	    this.resetHintPanel();
		if(this.isValidated()){
			_self.postValidate(true)
			return this.validationResult;
		}
		
		var params = { 
        	address1:$(this.cfg.add1Field).val(),
         	address2:$(this.cfg.add2Field).val(),
         	city:$(this.cfg.cityField).val(),
         	state:$(this.cfg.stateField).val(),
         	postalCode:$(this.cfg.zipField).val(),
         	validatedFlagField:$(this.cfg.validatedFlagField).val()
    	};

		$.ajax({
			url:'/retail/control/validateAddressAjax',
			data:params,
			beforeSend: function(){			
				if(!noHint){
					_self.showHideLoading(true);
				}else{
					_self.indicateLoading();
				}
			},
            success:function(data){
                _self.showHideLoading(false);
                var result=data.result;
                var validationResult = {checkValue:_self.getCurrentCheckValue(),status:'not_found', matches:[]}
                if(result.status=='found'){
                    validationResult['status']='found';
                } else if (result.status=='error'){
                    validationResult['status']='error';
                } else {
				    validationResult['matches']=result.matches;
				}
				_self.validationResult=validationResult
				_self.postValidate(noHint)
			},
	    	error:function(data){_self.showHideLoading(false)}
		});
		
		
	}
	
	
	this.indicateSuccess = function(){
		    $(this.cfg.validatedFlagField).val('Y')
		    this.isValidAddress = true;
			var errContent = '&lt;img src=&quot;https://test14.cliotest.com/static/images/tick.gif&quot;/>&lt;p style=&quot;display:inline-block;margin:0px;font-size:12px;&quot;>&amp;nbsp;&amp;nbsp;'+this.validateMessage+'&lt;/p>';
			var indicatorPanel = $(this.cfg.indicatorPanel)
			//alert(&quot;indicatorPanel...&quot;+indicatorPanel)
			indicatorPanel.show();
			indicatorPanel.html(errContent)
	}
	
	this.indicateLoading = function(){
		    var errContent = '&lt;img src=&quot;https://test14.cliotest.com/static/images/ajax-loader_small.gif&quot;/>';
			var indicatorPanel = $(this.cfg.indicatorPanel);
			indicatorPanel.show();
			indicatorPanel.html(errContent)
	}
	
	this.indicateFailure = function(){
	        var validator = this;
			$(validator.cfg.validatedFlagField).val('Y')
			this.isValidAddress = false;
			var trigHntId = ''
			var errContent = ''
            if (!this.validateOnClick) {
                if (this.validationResult.matches.length > 0) {
                    trigHntId = 'multi_hint_' + validator.cfg.formName;
                    errContent = '&lt;img style=&quot;top:-5px&quot; src=&quot;https://test14.cliotest.com/static/images/exclamatory.png&quot;/>&lt;span> Found multiple results, &lt;/span>&lt;a href=&quot;javascript:void(0)&quot; id=&quot;' + trigHntId + '&quot;>&lt;span class=&quot;onelevel-pink hightlight-link&quot;>click&lt;/span>&lt;/a>&lt;span> to select&lt;/span>';
                } else {
                    trigHntId = 'trigger_hint_' + validator.cfg.formName
                    if (this.validationResult.status == 'error') {
                        errContent = '&lt;a href=&quot;javascript:void(0)&quot; id=&quot;' + trigHntId + '&quot;>&lt;img style=&quot;top:-5px&quot; src=&quot;https://test14.cliotest.com/static/images/exclamatory.png&quot;/>&lt;/a>&lt;span>&amp;nbsp;' + validator.errorMessage + '&lt;/span>';
                    } else {
                        errContent = '&lt;a href=&quot;javascript:void(0)&quot; id=&quot;' + trigHntId + '&quot;>&lt;img style=&quot;top:-5px&quot; src=&quot;https://test14.cliotest.com/static/images/exclamatory.png&quot;/>&lt;/a>&lt;span>&amp;nbsp;' + validator.invalidErMesg + '&lt;/span>';
                    }
                }
                var indicatorPanel = $(this.cfg.indicatorPanel);
                indicatorPanel.show();
                indicatorPanel.html(errContent)
                $('#' + trigHntId).bind('click', function () {
                    validator.postValidate();
                })
            } else {
                validator.postValidate();
            }
	}
	
	this.postValidate=function(noHint){
	    var indicatorPanel = $(this.cfg.indicatorPanel)
		indicatorPanel.empty();
        var validator = this;
        var trigHntId = ''
        var errContent = ''
        $(validator.cfg.validatedFlagField).val('Y')
		if(this.validationResult.status=='found'){
			this.indicateSuccess();
			return;
		}
        if((this.validationResult.matches.length==0 &amp;&amp; this.validationResult.status=='not_found' || noHint ) &amp;&amp; !this.validateOnClick) {
                this.indicateFailure();
        }else if(this.validationResult.matches.length==0 &amp;&amp; this.validationResult.status=='not_found'){
                    trigHntId = 'trigger_hint_' + validator.cfg.formName
                    errContent = '&lt;a href=&quot;javascript:void(0)&quot; id=&quot;' + trigHntId + '&quot;>&lt;img style=&quot;top:-5px&quot; src=&quot;https://test14.cliotest.com/static/images/exclamatory.png&quot;/>&lt;/a>&lt;span>&amp;nbsp;' + validator.invalidErMesg + '&lt;/span>';
                    indicatorPanel.show();
                    indicatorPanel.html(errContent)
                }
                else{
                    this.showAddressHint();
                }
	}
	
	this.showAddressHint=function(){
		var tblContent = []
		for(var i=0;i&lt;this.validationResult.matches.length;i++){
			var addressHint = this.validationResult.matches[i];
			tblContent.push(&quot;&lt;tr>&lt;td>&lt;input style='width: 20px;' type='radio' name='chck1_&quot;+this.cfg.id+&quot;' value='&quot;+i+&quot;' class='hint_check_&quot;+this.cfg.id+&quot;'>&lt;/td>&quot;);
			tblContent.push(&quot;&lt;td>&lt;label>&quot;);
			tblContent.push(' '+addressHint.address1);
			if(addressHint.address2){
				tblContent.push(' '+addressHint.address2);
			}
			tblContent.push(', '+addressHint.city);
			tblContent.push(', '+addressHint.state);
			tblContent.push(', '+addressHint.postalCode);
			tblContent.push(&quot;&lt;/label>&lt;/td>&lt;/tr>&quot;);
			
		}
		tblContent.push(&quot;&lt;tr>&lt;td>&lt;input style='width: 20px;' type='radio' name='chck1_&quot;+this.cfg.id+&quot;' value='-1' class='hint_check_&quot;+this.cfg.id+&quot;'>&lt;/td>&quot;);
		tblContent.push(&quot;&lt;td>&lt;label>Original Address&lt;/label>&lt;td>&lt;/tr>&quot;);
        var validator=this;
        if (!this.validateOnClick) {
            $('#addressHint').empty();
            $('#addressHint').html(tblContent.join(''));

            $('#hint_select').unbind();
            $('#hint_select').bind('click',function(){validator.onHintSelect()});
            $.colorbox({inline:true,height:'450px',href: '#addressHintBox', top: 10,escKey: false, layClose: false});
        } else {
            this.originalAddress = {
                address1 : $(this.cfg.add1Field).val(),
                address2 : $(this.cfg.add2Field).val(),
                city : $(this.cfg.cityField).val(),
                state : $(this.cfg.stateField).val(),
                postalCode : $(this.cfg.zipField).val(),
                validatedFlagField : $(this.cfg.validatedFlagField).val('N')
            }
            $(this.cfg.hintIndicatorPanel).empty();
            $(this.cfg.hintIndicatorPanel).show();
            $('#addressHintWithNoModal').html(tblContent.join(''));
            $(this.cfg.hintIndicatorPanel).append($('#addressHintBoxWithNoModal').html());
            $('input.hint_check_'+this.cfg.id).each(function() {
                $(this).click(function(e) {
                    validator.onHintSelect();
                })
            })
        }
	 }

	this.onHintSelect=function(){
		var selectIndex=$('input.hint_check_'+this.cfg.id+':checked').val();
		if(!selectIndex || selectIndex==''){
			//TODO I18N
			alert('Please select a suggestion');
			return;
		}
		
		selectIndex = parseInt(selectIndex)
		if(selectIndex==-1){
			this.indicateFailure();
		}else{
			$(this.cfg.add1Field).unbind();
			$(this.cfg.add2Field).unbind();
			$(this.cfg.cityField).unbind();
			$(this.cfg.stateField).unbind();
			var hintAddress = this.validationResult.matches[selectIndex];
			$(this.cfg.add1Field).val(hintAddress.address1);
         	$(this.cfg.add2Field).val(hintAddress.address2);
         	$(this.cfg.cityField).val(hintAddress.city);
          if($(this.cfg.stateField).is(&quot;select&quot;)) {
         		$(this.cfg.stateField).select2().val(hintAddress.state).trigger('change');
         	} else {
         		$(this.cfg.stateField).val(hintAddress.state).trigger('change');
         	}
         	$(this.cfg.zipField).val(hintAddress.postalCode);
         	this.checkValue=this.getCurrentCheckValue();
			this.indicateSuccess();
			$(this.cfg.add1Field).bind('change',function(){this.backgroundValidate(this);});
			$(this.cfg.add2Field).bind('change',function(){this.backgroundValidate(this);});
			$(this.cfg.cityField).bind('change',function(){this.backgroundValidate(this);});
			$(this.cfg.stateField).bind('change',function(){
				if($(_self.cfg.add1Field).val() =='' || $(_self.cfg.cityField).val() =='' || $(_self.cfg.zipField).val() =='')  {
					 	return;
				}
				_self.backgroundValidate(this);
			});
		}
		$.colorbox.close();
       if (this.cfg.zipField==&quot;#selectedShippingAddressId_zip&quot;) {
           $(this.cfg.zipField).trigger(&quot;change&quot;);
       }
	}

	this.getCurrentCheckValue=function(){
		var add1 = $(this.cfg.add1Field).val();
		var add2 = $(this.cfg.add2Field).val();
		var city = $(this.cfg.cityField).val();
		var state = $(this.cfg.stateField).val();
		var zip = $(this.cfg.zipField).val();
		var validated = $(this.cfg.validatedFlagField).val()
		var checkValue=&quot;&quot;;
		if(add1){ checkValue+= $.trim(add1) }; checkValue+=&quot;_&quot;;
		if(add2){ checkValue+=$.trim(add2) }; checkValue+=&quot;_&quot;;
		if(city){ checkValue+=$.trim(city) }; checkValue+=&quot;_&quot;;
		if(state){ checkValue+=$.trim(state) }; checkValue+=&quot;_&quot;;
		if(zip){ checkValue+=$.trim(zip) }; checkValue+=&quot;_&quot;;
		if(validated){ checkValue+=$.trim(validated) };
		return checkValue;
	}
	
	this.showHideLoading=function(show){
		var addloader = $('#addloader');
		if(show){
			addloader.addClass('loading');
		}else{
			addloader.removeClass('loading');
		}
	}
	
	this.resetIndicatorPanel=function(){
		var indicatorPanel = $(this.cfg.indicatorPanel)
		indicatorPanel.empty();
	}

    this.resetHintPanel=function(){
        var hintIndicatorPanel = $(this.cfg.hintIndicatorPanel)
        this.validationResult = null;
        hintIndicatorPanel.empty();
        hintIndicatorPanel.hide();
    }
}

Please wait while address being verified......


      Address Suggestions
        
            
            
         
         
         
      




    
      Address Suggestions
      

    
    
  




    
        
            
                
        
        
            
                
                    
                
                
                    
                    
                
                
                    
                
            
        
    




    Notice: you must have a mailing address entered for the customer in case we need to ship backordered item(s) to her.
	
    
        
    
	
		
		
	    
	    
	    
	    
	    
        
	    
	    
		
		    
		    	Enter or Verify Guest Information
				
					First Name (Required):
						
								
				
				
				Last Name (Required):
					
						
				
		    
		    
		    
				Contact Information
				Note: Only email or home phone is required
				
				Email:
					
					
				
								
				Home Phone:
					
					
				
				Mobile Phone:
					
					
				
				
			
			
			
				
				Mailing Information
				Note: Address 1, City, State and Zip code are required
				
					
				
				
					
					
				                
	                
				 
					
					
					       CA - California                          
	               		
						AK - Alaska
						AL - Alabama
						AR - Arkansas
						AZ - Arizona
						CA - California
						CO - Colorado
						CT - Connecticut
						DC - District of Columbia
						DE - Delaware
						FL - Florida
						GA - Georgia
						HI - Hawaii
						IA - Iowa
						ID - Idaho
						IL - Illinois
						IN - Indiana
						KS - Kansas
						KY - Kentucky
						LA - Louisiana
						MA - Massachusetts
						MD - Maryland
						ME - Maine
						MI - Michigan
						MN - Minnesota
						MO - Missouri
						MS - Mississippi
						MT - Montana
						NC - North Carolina
						ND - North Dakota
						NE - Nebraska
						NH - New Hampshire
						NJ - New Jersey
						NM - New Mexico
						NV - Nevada
						NY - New York
						OH - Ohio
						OK - Oklahoma
						OR - Oregon
						PA - Pennsylvania
						RI - Rhode Island
						SC - South Carolina
						SD - South Dakota
						TN - Tennessee
						TX - Texas
						UT - Utah
						VA - Virginia
						VT - Vermont
						WA - Washington
						WI - Wisconsin
						WV - West Virginia
						WY - Wyoming
	               
	               
	               
	               	
	               	 
	                 
	                 
	                 
	                
	                
                    
                        
                    
                      Address validated by cabi.
                    

                    

			
			
			
				Shipping Information
				Shipping address same as mailing address
				Note: Address 1, City, State and Zip code are required
				
					
					
				
				
					
					
				
				
					
					       CA - California                          
	               	
						AK - Alaska
						AL - Alabama
						AR - Arkansas
						AZ - Arizona
						CA - California
						CO - Colorado
						CT - Connecticut
						DC - District of Columbia
						DE - Delaware
						FL - Florida
						GA - Georgia
						HI - Hawaii
						IA - Iowa
						ID - Idaho
						IL - Illinois
						IN - Indiana
						KS - Kansas
						KY - Kentucky
						LA - Louisiana
						MA - Massachusetts
						MD - Maryland
						ME - Maine
						MI - Michigan
						MN - Minnesota
						MO - Missouri
						MS - Mississippi
						MT - Montana
						NC - North Carolina
						ND - North Dakota
						NE - Nebraska
						NH - New Hampshire
						NJ - New Jersey
						NM - New Mexico
						NV - Nevada
						NY - New York
						OH - Ohio
						OK - Oklahoma
						OR - Oregon
						PA - Pennsylvania
						RI - Rhode Island
						SC - South Carolina
						SD - South Dakota
						TN - Tennessee
						TX - Texas
						UT - Utah
						VA - Virginia
						VT - Vermont
						WA - Washington
						WI - Wisconsin
						WV - West Virginia
						WY - Wyoming
	               
	               
	            
	            
	            	 
	            	 
	            	 
	            
	            
                
                    
                
                  Address validated by cabi.
                

                	
	                            
			
		
		
	
	 

	
		Next
	
	

  


$(document).ready(function(){
    $(&quot;#stateProvinceGeoId&quot;).select2({allowClear: true});
    $(&quot;#shippingStateProvinceGeoId&quot;).select2({allowClear: true});
    // Disabled the visited link for show order if mailing address is not verified or null.
    if($('#showId').val()!='' &amp;&amp; $('#mailAddressVerified').val() != 'Y') {
        $('.visited').addClass(&quot;not-active&quot;);
        $('.visited').addClass(&quot;disabled&quot;);
        $('.visited').removeClass(&quot;visited&quot;);
    }
    if($('#address1').val()!='' &amp;&amp; $('#mailAddressVerified').val() != 'Y' ){
        $('#addressValidationSection').show();
    }
    if($('#shipAddressVerified').val() != '' &amp;&amp;  $('#shipAddressVerified').val() != 'Y' &amp;&amp; !$('#copyMailAddrCheck').prop('checked')){
        $('#shippingAddressValidationSection').show();
    }
    
});

function duplicateEmailPopup() {
    $.colorbox({
        inline: true,
        href: '#duplicateEmailPopup',
        top: 10,
        width: 600,
        escKey: false,
        overlayClose: false
    });
}

function closePopup() {
    $.colorbox.close();
    $(&quot;#guest_info_form #guestId&quot;).val('');
}

function GuestForm(){
 	var _self = this
 	this.addressValidator = new AddressValidator()
 	this.shippingAddressValidator = new AddressValidator()
 	this.addressValidator.cfg.validatedFlagField = '#mailAddressVerified'
	this.shippingAddressValidator.cfg.validatedFlagField= '#shipAddressVerified'
	this.guestInfo = null
	this.orginalCheckValue = null
	
	this.init=function(guestInfo){
		var _self =this;
		this.guestInfo=guestInfo
		$(&quot;#homePhone&quot;).mask(formatForPhoneNumber,{placeholder:&quot; &quot;})
		$(&quot;#mobilePhone&quot;).mask(formatForPhoneNumber,{placeholder:&quot; &quot;})
		this.addressValidator.validateOnLoad = false
		this.addressValidator.validateOnClick =true;
		var addressCfgMap ={id: 'mailAddr',indicatorPanel:'li#addValidIndicator', hintIndicatorPanel: '#hint'}
        _self.addressValidator.init(addressCfgMap)
        $('#validateAddressButton').click(function(){
            _self.addressValidator.validateAddress(true)
        });
        
		this.shippingAddressValidator.validateOnLoad = false
		this.shippingAddressValidator.validateOnClick =true;
		var shippingCfgMap = {id:'shippingAddr', add1Field:'#shippingAddress1', add2Field:'#shippingAddress2', cityField:'#shippingCity', stateField:'#shippingStateProvinceGeoId', 
		    zipField:'#shippingPostalCode', indicatorPanel:'li#shippingAddValidIndicator', hintIndicatorPanel: '#shippingHint', buttonSection: '#shippingAddressValidationSection'};

        _self.shippingAddressValidator.init(shippingCfgMap);
            if($('#address1').val()!=''){
                if($('#mailAddressVerified').val() != 'Y' ){
                    $('#addressValidationSection').show();
                } else{
                    this.addressValidator.indicateSuccess();
                }
            }

            if($('#shipAddressVerified').val() != ''){
                if($('#shipAddressVerified').val() != 'Y' &amp;&amp; !$('#copyMailAddrCheck').prop('checked')){
                    $('#shippingAddressValidationSection').show();
                } else {
                    this.shippingAddressValidator.indicateSuccess();
                }
            }

        $('#validateShipAddressButton').click(function(){
            _self.shippingAddressValidator.validateAddress(true);
        });
        
        this.addressValidator.onHintSelect=function(){
            onHintSelectOverride(_self.addressValidator);
        }
        this.shippingAddressValidator.onHintSelect=function(){
            onHintSelectOverride(_self.shippingAddressValidator);
        }
    function onHintSelectOverride(thisObj) {
        var selectIndex=$('input.hint_check_'+thisObj.cfg.id+':checked').val();
        if(!selectIndex || selectIndex==''){
            //TODO I18N
            alert('Please select a suggestion');
            return;
        }

        selectIndex = parseInt(selectIndex)
        if(selectIndex==-1){
            $(thisObj.cfg.add1Field).unbind();
            $(thisObj.cfg.add2Field).unbind();
            $(thisObj.cfg.cityField).unbind();
            $(thisObj.cfg.stateField).unbind();
            $(thisObj.cfg.add1Field).val(thisObj.originalAddress.address1);
            $(thisObj.cfg.add2Field).val(thisObj.originalAddress.address2);
            $(thisObj.cfg.cityField).val(thisObj.originalAddress.city);
            $(thisObj.cfg.stateField).select2().val(thisObj.originalAddress.state).trigger('change');
            $(thisObj.cfg.zipField).val(thisObj.originalAddress.postalCode);
            $(thisObj.cfg.validatedFlagField).val('Y');
            thisObj.resetIndicatorPanel();
        }else{
            $(thisObj.cfg.add1Field).unbind();
            $(thisObj.cfg.add2Field).unbind();
            $(thisObj.cfg.cityField).unbind();
            $(thisObj.cfg.stateField).unbind();
            var hintAddress = thisObj.validationResult.matches[selectIndex];
            $(thisObj.cfg.add1Field).val(hintAddress.address1);
             $(thisObj.cfg.add2Field).val(hintAddress.address2);
             $(thisObj.cfg.stateField).select2().val(hintAddress.state).trigger('change');
             $(thisObj.cfg.cityField).val(hintAddress.city);
             $(thisObj.cfg.zipField).val(hintAddress.postalCode);
             $(thisObj.cfg.validatedFlagField).val(hintAddress.validatedFlagField);
             
            thisObj.checkValue=thisObj.getCurrentCheckValue();
            thisObj.indicateSuccess();
            $(thisObj.cfg.add1Field).bind('change',function(){thisObj.backgroundValidate(thisObj);});
            $(thisObj.cfg.add2Field).bind('change',function(){thisObj.backgroundValidate(thisObj);});
            $(thisObj.cfg.cityField).bind('change',function(){thisObj.backgroundValidate(thisObj);});
            $(thisObj.cfg.stateField).bind('change',function(){
                if($(thisObj.cfg.add1Field).val() =='' || $(thisObj.cfg.cityField).val() =='' || $(thisObj.cfg.zipField).val() =='')  {
                         return;
                }
                thisObj.backgroundValidate(thisObj);
            });
        }
        if ($('#copyMailAddrCheck').prop('checked')) {
            _self.copyMailAddress();
		}
    }
		
        $('#next_action_btn').bind('click', function(){
            if(!_self.validateNameLength()) {
                alert('The total no. of characters of First Name and Last Name together cannot exceed 35 characters');
                return false;
            }
            var guestEmailId = $('#emailAddress').val();
            if (guestEmailId) {
                if( !isValidEmailAddress(guestEmailId) ) {
                    var htmlValidateEmailMsg = 'Please enter a valid email address &amp;#40;like john&amp;#64;email.com&amp;#41;.';
                    alert($('&lt;span>&lt;/span>').html(htmlValidateEmailMsg).text());
                    return false;
                }
            }
            var url = $(this).attr('rel');
            var partyId = $(&quot;#guestId&quot;).val();
            jQuery.ajax({
                url: '/backoffice/control/verifyDuplicateContactEmail',
                type: 'POST',
                data: $(&quot;#guest_info_form&quot;).serialize(),
                success: function (data) {
                    var isExistingContact = data['isExistingContact']
                    if(isExistingContact == 'Y' &amp;&amp; !partyId){
                        if (data['errorMsg']) {
                            $('#duplicateErrorMessage').empty();
                            $('#duplicateErrorMessage').append('&lt;span style=&quot;display:inline;margin:0px;&quot;>'+data['errorMsg']+'&lt;/span>');
                            $(&quot;#guest_info_form #guestId&quot;).val(data['partyId']);
                            duplicateEmailPopup();
                        }
                    }else{
                        _self.saveAndGoNext(url);
                    }
                 }
            });
        })
		
		if($('#shippingAddress1').val()!='' &amp;&amp; this.addressValidator.getCurrentCheckValue()==this.shippingAddressValidator.getCurrentCheckValue()){
			$('#copyMailAddrCheck').prop('checked',true);
		}
		
		
		$('#copyMailAddrCheck').bind('change',function(){
			if(this.checked){
               if ($('#shipAddressVerified').val() == 'Y') {
                    $('#shippingAddressValidationSection').hide();
               } else {
                   $('#shippingAddressValidationSection').show();
               }
				_self.copyMailAddress()
			} else {
                $(&quot;#shippingAddValidIndicator&quot;).html('');
                $(&quot;input#shippingAddress1&quot;).val('');
                $(&quot;input#shippingAddress2&quot;).val('');
                $(&quot;input#shippingCity&quot;).val('');            
                $(&quot;input#shippingPostalCode&quot;).val('');
                $(&quot;#shippingStateProvinceGeoId&quot;).val('');
                $(&quot;#s2id_shippingStateProvinceGeoId a span&quot;).css('color','gray').text('--');
                $('#shippingAddressValidationSection').hide();
			}
		});
		
		$('#address1,#address2, #city, #stateProvinceGeoId, #postalCode,#shippingAddress1,#shippingAddress2,#shippingCity,#shippingPostalCode,#shipAddressVerified')
		.bind('change', function(){
			$('#copyMailAddrCheck').prop('checked',false);
		})
	}
    this.validateNameLength = function() {
        var firstName = $.trim($(&quot;#firstName&quot;).val());
        var lastName = $.trim($(&quot;#lastName&quot;).val());
        if(firstName &amp;&amp; lastName &amp;&amp; ($.trim(firstName + &quot; &quot; + lastName)).length > 35) {
            return false;
        }
        return true;
    }
	this.copyMailAddress=function(){
		$('#shippingAddress1').val($('#address1').val())
		$('#shippingAddress2').val($('#address2').val())
		$('#shippingCity').val($('#city').val())
		$('#shippingStateProvinceGeoId').val($('#stateProvinceGeoId').val())
		$(&quot;#s2id_shippingStateProvinceGeoId a span&quot;).css(&quot;color&quot;,&quot;black&quot;).text($('#s2id_stateProvinceGeoId a span').text());
		$('#shippingPostalCode').val($('#postalCode').val())
		$('#shippingAddValidIndicator').html($(&quot;#addValidIndicator&quot;).html());
        if($(&quot;#mailAddressVerified&quot;).val() == 'Y'){
            $('#shippingAddressValidationSection').hide();
            $(&quot;#shippingAddValidIndicator&quot;).show();
        } 
	}
	
	this.saveAndGoNext=function(nextUrl){
	  	if ($('#copyMailAddrCheck').prop('checked')) {
            $('#shipAddressVerified').val($('#mailAddressVerified').val());
		}
            if(!this.guestInfo.valiateGuestForm()){
                return
            }
        if (true) {
            var preparedWarningMessage = 'The following address need to be validated before you can continue&lt;br>&lt;/br>&lt;ul>';
            var gotError = false;
    
            if ($('#mailAddressVerified').val() != 'Y') {
                var gotError = true;
                preparedWarningMessage += '&lt;li>Mailing Address&lt;/li>';
            }
            if ($('#shipAddressVerified').val() != 'Y' &amp;&amp; !$('#copyMailAddrCheck').prop('checked')) {
                var gotError = true;
                preparedWarningMessage += '&lt;li>Shipping Address&lt;/li>';
            }
            if (gotError) {
                preparedWarningMessage += '&lt;/ul>'
                showToastNotification('warning', preparedWarningMessage, false);
                return false;
            }
        }
		var NextViewHandler = function(url){
			if(window.checkoutController !=undefined){
				checkoutController.loadTabByUrl(url)
			}else{
				window.location.href=url
			}
		}

		var partyId = $('#guestId').val();

		if(!document.forms['guest_form']){
			nextUrl+=partyId
			new NextViewHandler(nextUrl)
		}

		var modified = this.isModified()
		if(modified){
			this.guestInfo.saveGuestInfo(NextViewHandler,nextUrl)
		}else{
                nextUrl+=partyId
            new NextViewHandler(nextUrl)
		}
	}
	
	this.getCurrentCheckValue=function(){
		var firstName = $('#firstName').val()
		var lastName = $('#lastName').val()
		var homePhone = $('#homePhone').val()
		var mobilePhone = $('#mobilePhone').val()
		var emailAddress = $('#emailAddress').val()

		var checkValue=&quot;&quot;
		if(firstName){ checkValue+= $.trim(firstName) }; checkValue+=&quot;_&quot;;
		if(lastName){ checkValue+=$.trim(lastName) }; checkValue+=&quot;_&quot;;
		if(homePhone){ checkValue+=$.trim(homePhone) }; checkValue+=&quot;_&quot;;
		if(mobilePhone){ checkValue+=$.trim(mobilePhone) }; checkValue+=&quot;_&quot;;
		if(emailAddress){ checkValue+=$.trim(emailAddress) };
		return checkValue
	}
	
	this.isModified=function(){
		var guestInfoModified =  (this.orginalCheckValue!=this.getCurrentCheckValue())
		var addressModified = this.addressValidator.isModified()
		var shippingAddressModified = this.shippingAddressValidator.isModified()
		return guestInfoModified || addressModified || shippingAddressModified
	}
}

var guestForm = new GuestForm()

function enableExistingPartyRelationship(){
    $.ajax({
        url : '/backoffice/control/enableContactRelationship',
        type : 'POST',
        data : $(&quot;#guest_info_form&quot;).serialize(),
        success : function (data) {
            if (!data[&quot;isRelEnabled&quot;]) {
               closePopup();
               $(&quot;#errorNote&quot;).empty();
               $(&quot;#errorContactDiv&quot;).show();
               $(&quot;#errorNote&quot;).append('Unable to add the previously existing contact');
            }else{
                $.colorbox.close();
                var url = $(&quot;#next_action_btn&quot;).attr('rel');
                guestForm.saveAndGoNext(url);
            }
         }
    });
}
function showToastNotification(type, message, groovyError) {
    if (groovyError) {
        // Regex used to get error message from groovy errors
        var rgx = /\(([^)]+)\)/;
        var match = message.match(rgx);
        var newText = match &amp;&amp; match[1];
        toastr[type](newText);
    } else {
        toastr[type](message);
    }
}





CheckoutTab='customer_info'
function GuestInfo(){
	var self=this;
	this.opts = {
		selectedPartyId:'',
		currentPartyId:'102941430',
		showId:'',
		consultantId:'100000042',
		guestInfoSection:'#guest_info_section',
		addEditGuestFormURL:'/retail/control/AddEditGuestForm',
		addEditGuestInfoURL:'/retail/control/AddEditGuestInfo',
		returnToUrl:&quot;changeOrderRecipient?recipientId=&quot;,
		returnToBtnCaption:&quot;Next&quot;
	}
	
	this.getTabConfig=function(){
		return ['lookupGuest','cons', 'new']
	}

	this.init=function(){
		
		$('#guest_lookup').autocomplete(this.guestLookupConfig)
		
		$('.recipient_type').bind('click', function(){
			self.recipientTypeClicked(this.value)
		});
		
		var tabConfig = this.getTabConfig()
		
		if(tabConfig.indexOf('cons')&lt;0){
			$('#cons_radio').parent().remove()
		}
		
		if(tabConfig.indexOf('lookupGuest')&lt;0){
			$('#cust_radio').parent().remove()
		}
		
		if(tabConfig.indexOf('new')&lt;0){
			$('#newcust_radio').parent().remove()
		}
			
		if(tabConfig.length>0){
		 	$('#guest_actions').show()
		}
		
		this.loadDefault()
	}

	this.loadDefault=function() {
        if (&quot;&quot;) {
            $('#cust_radio').prop('checked', 'checked');
            $('#guest_lookup').show();
            $(&quot;#guest_lookup&quot;).attr(&quot;disabled&quot;, &quot;disabled&quot;);
            this.recipientTypeClicked('cust');
        } else {
            var currentPartyId = this.opts.currentPartyId
            if (currentPartyId != '' &amp;&amp; currentPartyId == this.opts.consultantId) {
                $('#cons_radio').prop('checked', 'checked');
                this.recipientTypeClicked('cons');
                return;
            }
            if ($.trim(currentPartyId) != '') {
                $('#cust_radio').prop('checked', 'checked');
                $('#guest_lookup').show();
                this.loadGuestForm(currentPartyId);
            } else {
                $('#newcust_radio').prop('checked', 'checked');
                this.recipientTypeClicked('newcust');
            }
        }
    }
	
	this.recipientTypeClicked=function(recptType){
			$('#guest_info_content').hide();
			$('#guest_lookup').hide();
			if(recptType=='cons'){
                // Enable the visited links when selected party is consultant.
                var currentPartyId = '102941430'
                if (self.opts.consultantId == currentPartyId) {
                   $('.not-active').removeClass(&quot;disabled&quot;);
                   $('.not-active').addClass(&quot;visited&quot;);
                   $('.not-active').removeClass(&quot;not-active&quot;)
               } else {
                   // Disable the visited links on recipient change
                   $('.visited').addClass(&quot;not-active&quot;)
                   $('.visited').addClass(&quot;disabled&quot;);
                   $('.visited').removeClass(&quot;visited&quot;);
               }
				self.loadGuestForm(self.opts.consultantId)
				return;
			}
            else if(recptType=='cust' &amp;&amp; !(&quot;&quot;)){
				$('#guest_lookup').val('')
				$('#guest_lookup').show()
            } else if (recptType=='cust' &amp;&amp; (&quot;&quot;)) {
                $('#guest_lookup').val('Test Consultant 2')
                $('#guest_lookup').show()
                self.loadGuestForm('')
            }
			else if(recptType=='newcust'){
				self.loadGuestForm('')
				return;
			}
	}
	
    this.loadGuestForm=function(partyId){
        this.opts.selectedPartyId=partyId;
        this.showLoading(true);
        var editMode=true;
        $(&quot;#partyId&quot;).val(partyId);
        if(this.opts.consultantId!='' &amp;&amp; this.opts.consultantId==partyId){
            editMode=false;
        }
        var params = {guestId:partyId,consultantId:this.opts.consultantId,returnToUrl:this.opts.returnToUrl,editMode:editMode};
        if(this.opts.showId &amp;&amp; this.opts.showId!=''){
            params['showId']=this.opts.showId;
        }
        jQuery.ajax({
          type: 'POST',
          url: this.opts.addEditGuestFormURL,
          data: params,
          async: false}).done(function(data){
            var response = data;
            $(&quot;#guest_info_section&quot;).html(response);
            self.hideLoading();
            self.guestFormOnLoad();
        });
	}
	
	this.guestFormOnLoad=function(){
		guestForm.init(this)
		$('#returnToActionLabel').text(self.opts.returnToBtnCaption)
	}
	
	this.saveGuestInfo=function(NextViewHandler, nextViewUrl){
		$('#guest_info_content').hide()
		self.showLoading()
		$.ajax({
            url: this.opts.addEditGuestInfoURL,
            type: 'POST',
           	data :  $(&quot;#guest_info_form&quot;).serialize(),
            success: function(data, textStatus, jqXHR) {
            	var response = data.result
            	self.hideLoading()
            	if(response){
            		if(response.status=='success'){
            			nextViewUrl+=response.partyId
            			new NextViewHandler(nextViewUrl)
            			if(window.reloadCartSummary !=undefined){reloadCartSummary()}
            		}else{
            			$('#guest_info_content').show()
            			self.showResponseError(response.errorList)            			
            		}
            		
            	}else{
            		$('#guest_info_content').show()
            		self.showResponseError(['Something went wrong!'])            		
            	}           	
	    	},
	    	error: function(xhr, status, error) {
	    		self.showResponseError(['Something went wrong!'])	    		
	    	}	    
        })   
	}
	
	this.guestLookupConfig={
		minLength:3,
		source:function( request, response ){    
	    	var serviceUrl = '/retail/control/lookupGuest?term='+request.term
	   	    $.getJSON(serviceUrl, function(data) {		   	    	
	   	    	 var suggestions = [];   	
	   	    	 $.each(data.search_result, function(i, item){
	   	    	 	suggestions.push({ label: item.firstName+' '+item.lastName, value: item.partyId })
	   	    	 })
	   	    	 if(suggestions.length==0){
	   	    		suggestions.push({ label: 'No matching result found', value:null });
	   	    	 }
	   	    	 response(suggestions);  
	   	    })        		
	   },	   
	   select:function(e, ui) {			   	
		   var partyId = ui.item.value
		   if(!partyId){
			   return;
		   }
		   $(&quot;#partyId&quot;).val(partyId);
		   ui.item.value=ui.item.label
		   // Enable the steps if selected party is current party (party for which steps stored) else disabled it
           var currentPartyId = '102941430'
           if (partyId == currentPartyId) {
               $('.not-active').removeClass(&quot;disabled&quot;);
               $('.not-active').addClass(&quot;visited&quot;);
               $('.not-active').removeClass(&quot;not-active&quot;)
           } else {
               $('.visited').addClass(&quot;not-active&quot;)
               $('.visited').addClass(&quot;disabled&quot;);
               $('.visited').removeClass(&quot;visited&quot;);
           }
		   self.loadGuestForm(partyId)
		},	    
	}
	
	this.showResponseError=function(errorList){
		var erMsgSection=$('#error_section')
		erMsgSection.html('')
		erMsgSection.show();
		var errorHtml =&quot;&quot;
		for(var i=0;i&lt;errorList.length;i++){
			errorHtml += (errorList[i]+&quot;&lt;br/>&quot;)
		}
		erMsgSection.html(errorHtml);
	}
	
	this.showError=function(errorList){
		for(var i=0;i&lt;errorList.length;i++){
			var errorInfo = errorList[i]
			errorInfo['formName']='guest_form'
			errorHanlder.renderFormError(errorInfo)
		}
		
	}
	
	this.showLoading= function(removeContent){
		var erMsgSection=$('#error_section')
		erMsgSection.html('')
		var searchResultSection=this.opts.guestInfoSection
		var LoadingHtml ='&lt;div id=&quot;loading_div&quot; style=&quot;width:100%;text-align:center;&quot;>&lt;br/>&lt;br/>&lt;br/>&lt;br/>';
		LoadingHtml+='&lt;img src=&quot;https://test14.cliotest.com/static/images/ajax-loader_small.gif&quot; />&lt;span>&lt;br/>Loading...&lt;/span>&lt;/div>';
		var targetDiv= $(searchResultSection)
		if(removeContent){
			targetDiv.html('')
		}	
		$(LoadingHtml).appendTo(targetDiv)
	}
	
	this.hideLoading=function(){
		$('#loading_div').remove()
	}
	
	
	this.valiateGuestForm=function(){
			$('.form-field-error-display').remove()
			var errorList=[]
			var guestForm=document.forms['guest_form']
			if($.trim(guestForm.firstName.value)==''){
				errorList.push({fieldName:'firstName',msg:'Please enter First Name'})
			}
			
			if($.trim(guestForm.lastName.value)==''){
				errorList.push({fieldName:'lastName',msg:'Please enter Last Name'})
			}
			
			if($.trim(guestForm.homePhone.value)=='' &amp;&amp; $.trim(guestForm.mobilePhone.value)=='' &amp;&amp; $.trim(guestForm.emailAddress.value)==''){
				errorList.push({fieldName:'emailAddress',msg:'Please enter home Phone Number or Email Address'})
			}
			if($.trim(guestForm.city.value)==''){
				errorList.push({fieldName:'city',msg:'Please enter city'})
			}
			if(($.trim(guestForm.address1.value))==''){
				errorList.push({fieldName:'address1',msg:'Please enter Address 1'})
			}
			if($.trim(guestForm.stateProvinceGeoId.value)==''){
				errorList.push({fieldName:'stateProvinceGeoId',msg:'Please select state'})
			}
			if($.trim(guestForm.postalCode.value)==''){
				errorList.push({fieldName:'postalCode',msg:'Please enter zip code'})
			}
			
				//validate shipping address
				if($.trim(guestForm.shippingAddress1.value)==''){
					errorList.push({fieldName:'shipaddress1',msg:'Please enter Address 1'})
				}
				
				if($.trim(guestForm.shippingCity.value)==''){
					errorList.push({fieldName:'shippingCity',msg:'Please enter city'})
				}
				
				if($.trim(guestForm.shippingStateProvinceGeoId.value)==''){
					errorList.push({fieldName:'shippingStateProvinceGeoId',msg:'Please select state'})
				}
				
				if($.trim(guestForm.shippingPostalCode.value)==''){
					errorList.push({fieldName:'shippingPostalCode',msg:'Please enter zip code'})
				}
				

			if(errorList.length>0){
				self.showError(errorList)
				return false;
			}
			
			return true
	}
	
	
	

} 






	
		$(document).ready(function(){
			var guestInfo = new GuestInfo()
			guestInfo.getTabConfig=function(){
					return ['lookupGuest', 'new']
			}
			var consId = '100000042'
			if(guestInfo.opts.currentPartyId==consId){
				guestInfo.opts.currentPartyId=''
			}
			guestInfo.init()
			$(&quot;#notes&quot;).hide();
		});
	



	


 


		
		


	
	
		
		
	
	
</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath</name>
      <type>Main</type>
      <value>id(&quot;wrapper&quot;)</value>
   </webElementProperties>
   <webElementXpaths>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:attributes</name>
      <value>//div[@id='wrapper']</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:position</name>
      <value>//div</value>
   </webElementXpaths>
</WebElementEntity>
