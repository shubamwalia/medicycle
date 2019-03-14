<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="bootstraplinks.html"%>
<%@ include file="navbar.jsp"%>
</head>
<body>
<%
	String username = (String)session.getAttribute("username");
	if(username == null){
		response.sendRedirect("Index.jsp");
	}
%>
<div class="p-5">
<%
String addvar = request.getParameter("add");
if((addvar!=null)&&(addvar.equals("success"))){
%>
<div class="alert alert-success alert-dismissible fade show" role="alert">
			  Successfully Added
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
</div>
<%
}
%>
</div>
<div class="container p-5">
  <div class="row">
    <div class="col">
      <div class="card" style="width: 18rem;">
		  <img src="https://revcycleintelligence.com/images/site/features/_normal/rural_hospital.png" height="200" width="400" class="card-img-top" alt="...">
		  <div class="card-body">
		  	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addhospital">Add Hospital</button>
		  </div>
	  </div>
    </div>
    <div class="col">
      <div class="card" style="width: 18rem;">
		  <img src="https://mdxvitals-res.cloudinary.com/image/upload/q_auto/f_auto/w_550,dpr_auto/v1539099898/homepage_vector_doctors-02.png" height="200" width="400" class="card-img-top" alt="...">
		  <div class="card-body">
		    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#adddoctor">Add Doctor</button>
		  </div>
	  </div>
    </div>
    <div class="col">
      <div class="card" style="width: 18rem;">
		  <img src="https://aemstatic-ww2.azureedge.net/content/dam/diq/online-articles/2016/06/happy-dental-patients.jpg.scale.LARGE.jpg" class="card-img-top" alt="..." height="200" width="400">
		  <div class="card-body">
		    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addpatient">Add Patient</button>
		  </div>
	  </div>
    </div>
  </div>
</div>





<div class="modal fade" id="addhospital"  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Hospital</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="addhospital" method="post">
		  <div class="form-group">
		    <label>Hospital Name</label>
		    <input type="text" class="form-control" placeholder="Enter hospital name" name="name">
		  </div>
		  <div class="form-group">
		    <label>Hospital City</label>
		    <input type="text" class="form-control" placeholder="Enter city" name="city">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="adddoctor"  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Doctor</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="adddoctor" method="post">
		  <div class="form-group">
		    <label>Doctor Name</label>
		    <input type="text" class="form-control" placeholder="Enter doctor name" name="name">
		  </div>
		  <div class="form-group">
		    <label>Doctor Designation</label>
		    <input type="text" class="form-control" placeholder="Enter designation" name="designation">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="addpatient"  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Patient</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="addpatient" method="post">
		  <div class="form-group">
		    <label>Patient Name</label>
		    <input type="text" class="form-control" placeholder="Enter patient name" name="name">
		  </div>
		  <div class="form-group">
		    <label>Patient disease</label>
		    <input type="text" class="form-control" placeholder="Enter disease" name="disease">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>