<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<div class="row carousel-holder">

    <div class="col-md-3">
        <%@ include file="category-menu.jsp" %>
    </div>

    <div class="col-md-9">
        <div class="row">
            <div class="col-xs-12">
                <div class="row">
                    <div class="col-xs-12 col-sm-5 col-md-7">
                        <img src="data:image/png;base64,${bike.imageBase64}" alt=""/>
                    </div>
                    <div class="col-xs-12 col-sm-7 col-md-5">
                        <h1>${bike.bikeName}</h1>
                        <p > <span>${bike.price} </span> </p>
                        
                        <form class="form-inline" action="<c:url value="/cart.html?action=add"/>" method="post">
                            <input type="hidden" name="bikeID" value="${bike.bikeId}">
                           <div class="form-group">
                               <label for="qty">Quantity: </label>
                              <input type="number" step="1" min="1" name="qty" value="1" title="SL" class="lam form-control" style="width: 100px;">
                           </div>
                            <button type="submit" class="btn btn-default">Add To Cart</button>
                        </form>
                    
                </div>
            </div>

        </div>
    </div>
    <div>
        ${bike.description}
    </div>

</div>


