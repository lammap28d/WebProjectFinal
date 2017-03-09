<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="row carousel-holder">

	<div class="col-md-3">
		<%@ include file="category-menu.jsp" %>
	</div>

	<div class="col-md-9">
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img class="slide-image"
						src="<c:url value="/resources/images/banners/banner_refri.jpg"/>"
						alt="">
				</div>
				<div class="item">
					<img class="slide-image"
						src="<c:url value="/resources/images/banners/banner_household.jpg"/>"
						alt="">
				</div>
				<div class="item">
					<img class="slide-image" src="http://placehold.it/800x300" alt="">
				</div>
			</div>
			<a class="left carousel-control" href="#carousel-example-generic"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left"></span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>

</div>

<div class="row">
 <c:forEach items="${bikes}" var="bike">
	<div class="col-sm-4 col-lg-4 col-md-4">
		<div class="thumbnail">
			<img src="data:image/png;base64,${bike.imageBase64}" alt=""/>
			<div class="caption">
				<h4 class="pull-right">${bike.Price}</h4>
				<h4>
					<a href="#">${bike.bikeName}</a>
				</h4>
				<p>${bike.description}</p>
			</div>
			<div class="ratings">
				<p class="pull-right">15 reviews</p>
				<p>
					<span class="glyphicon glyphicon-star"></span> <span
						class="glyphicon glyphicon-star"></span> <span
						class="glyphicon glyphicon-star"></span> <span
						class="glyphicon glyphicon-star"></span> <span
						class="glyphicon glyphicon-star"></span>
				</p>
			</div>
		</div>
	</div>
        </c:forEach>
    
        
    <c:forEach items="${bikes}" var="bike">
        
        <div class="col-sm-4 col-lg-4 col-md-4">
		<div class="thumbnail">
			<img src="data:image/png;base64,${bike.imageBase64}" alt=""/>
			<div class="caption">
				<h4 class="pull-right">${bike.Price}</h4>
				<h4>
					<a href="#">${bike.bikeName}</a>
				</h4>
				<p>${category.categoryName}</p>
			</div>
			<div class="ratings">
				<p class="pull-right">12 reviews</p>
				<p>
					<span class="glyphicon glyphicon-star"></span> <span
						class="glyphicon glyphicon-star"></span> <span
						class="glyphicon glyphicon-star"></span> <span
						class="glyphicon glyphicon-star"></span> <span
						class="glyphicon glyphicon-star-empty"></span>
				</p>
			</div>
		</div>
	</div>
    </c:forEach>
	

	


	