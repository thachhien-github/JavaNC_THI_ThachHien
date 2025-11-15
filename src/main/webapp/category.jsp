<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="shared/header.jsp" />
<jsp:include page="shared/nav.jsp" />

<div class="container mt-3">
    <div class="row">

        <!-- Danh sách thể loại bên trái -->
        <div class="col-md-3">
            <h5 class="alert alert-info text-center">Category</h5>
            <ul class="list-group">
                <c:forEach var="tl" items="${dsmaloai}">
                    <li class="list-group-item">
                        <a href="san-pham?maloai=${tl.maloai}">
                            ${tl.tenloai}
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <!-- Sản phẩm chính bên phải -->
        <div class="col-md-9">
            <h4 class="alert alert-primary">
                Sản phẩm thể loại: ${theLoaiChon.tenloai} (Tổng: ${fn:length(dsSp)})
            </h4>

            <div class="row">
                <c:forEach var="sp" items="${dsSp}">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="card mb-3">
                            <div class="card-header">${sp.tensp}</div>
                            <div class="card-body text-center">
                                <img class="card-img-top" 
                                     src="assets/images/products/${sp.hinh}" 
                                     alt="${sp.tensp}">
                            </div>
                            <div class="card-footer">
                                <div class="row">
                                    <div class="col">
                                        <p class="btn btn-danger btn-block">
                                        <fmt:formatNumber value="${sp.dongia}" type="number" /> đ
                                        </p>
                                    </div>
                                    <div class="col">
                                        <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>
</div>

<jsp:include page="shared/footer.jsp" />
