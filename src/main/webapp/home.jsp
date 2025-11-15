<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="shared/header.jsp" />
<jsp:include page="shared/nav.jsp" />

<div class="container mt-3">
    <h4 class="alert alert-primary">Sản phẩm khuyến mãi</h4>
    <div class="row">
        <c:forEach var="sp" items="${spkm}">
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card mb-3">
                    <div class="card-header">${sp.tensp}</div>
                    <div class="card-body text-center">
                        <img class="card-img-top" src="assets/images/products/${sp.hinh}" alt="${sp.tensp}">
                    </div>
                    <div class="card-footer">
                        <div class="row">
                            <div class="col">
                                <p class="btn btn-danger btn-block">
                                    <fmt:formatNumber value="${sp.dongia}" type="number"/> đ
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

<jsp:include page="shared/footer.jsp" />
