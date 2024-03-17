<template>
  <div class="content">
    <div class="header text-center">
      <h1>Quản lý giao dịch nhà và đất</h1>
    </div>
    <div class="body">

      <div class="d-flex justify-content-center my-5">
        <div class="col-3 me-3">
          <input class="form-control" type="text" placeholder="Nhập tên khách hàng" />
        </div>
        <div class="col-2 me-3">
          <select class=" form-select">
            <option disabled selected>Click me</option>
          </select>
        </div>
        <div class="col-2">
          <button class="btn btn-primary ">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search me-2"
              viewBox="0 0 16 16">
              <path
                d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
            </svg>
            Tìm kiếm</button>
        </div>
      </div>

      <div class="mb-4">
        <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#modalAdd">
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
            class="bi bi-plus-circle me-2" viewBox="0 0 16 16">
            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
            <path
              d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4" />
          </svg>
          Thêm mới
        </button>
      </div>
      <div>
        <table class="table table-striped table-hover table-bordered">
          <thead>
            <tr>
              <th>Mã giao dịch</th>
              <th>Loại dịch vụ</th>
              <th>Ngày giao dịch</th>
              <th>Đơn giá (VND/m2)</th>
              <th>Diện tích (m2)</th>
              <th>Tên khách hàng</th>
              <th>Số điện thoại</th>
              <th>Email</th>
              <th class="text-center">Chi tiết</th>
              <th class="text-center">Xóa</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>MGD-10</td>
              <td>Đất</td>
              <td>2023-02-01</td>
              <td>600.000</td>
              <td>100</td>
              <td>Hồ Xuân Đại</td>
              <td>0987620752</td>
              <td>hoxuandai02@gmail.com</td>
              <td class="text-center">
                <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalAttribute">
                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                    class="bi bi-eye-fill " viewBox="0 0 16 16">
                    <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0" />
                    <path
                      d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8m8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7" />
                  </svg>
                </button>
              </td>
              <td class="text-center">
                <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modalDel">
                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                    class="bi bi-x-octagon" viewBox="0 0 16 16">
                    <path
                      d="M4.54.146A.5.5 0 0 1 4.893 0h6.214a.5.5 0 0 1 .353.146l4.394 4.394a.5.5 0 0 1 .146.353v6.214a.5.5 0 0 1-.146.353l-4.394 4.394a.5.5 0 0 1-.353.146H4.893a.5.5 0 0 1-.353-.146L.146 11.46A.5.5 0 0 1 0 11.107V4.893a.5.5 0 0 1 .146-.353zM5.1 1 1 5.1v5.8L5.1 15h5.8l4.1-4.1V5.1L10.9 1z" />
                    <path
                      d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                  </svg>
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>

  <!-- MODAL THÔNG TIN -->
  <div class="modal" tabindex="-1" id="modalAttribute">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h3 class="modal-title">Chi tiết giao dịch</h3>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="mb-3 d-flex">
            <p>Mã giao dịch: </p>

          </div>
          <div class="mb-3 d-flex">
            <p>Loại dịch vụ: </p>
            <div></div>
          </div>
          <div class="mb-3 d-flex">
            <p>Ngày giao dịch: </p>
            <div></div>
          </div>
          <div class="mb-3 d-flex">
            <p>Đơn giá: </p>
            <div></div>
          </div>
          <div class="mb-3 d-flex">
            <p>Diện tích: </p>
            <div></div>
          </div>
          <div class="mb-3 d-flex">
            <p>Tên khách hàng: </p>
            <div></div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
        </div>
      </div>
    </div>
  </div>

  <!-- MODAL THÊM-->
  <div class="modal" tabindex="-1" id="modalAdd">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h3 class="modal-title">Thêm mới giao dịch</h3>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="mb-3 d-flex">
            <p>Mã giao dịch</p>
            <input class="form-control" type="text" />
          </div>
          <div class="mb-3 d-flex">
            <p>Loại dịch vụ</p>
            <select class="form-select">
              <option>Đất</option>
              <option>Nhà và đất</option>
            </select>
          </div>
          <div class="mb-3 d-flex">
            <p>Ngày giao dịch</p>
            <input id="startDate" class="form-control" type="date" />
          </div>
          <div class="mb-3 d-flex">
            <p>Đơn giá</p>
            <input class="form-control" type="text" />
          </div>
          <div class="mb-3 d-flex">
            <p>Diện tích</p>
            <input class="form-control" type="text" />
          </div>
          <div class="mb-3 d-flex">
            <p>Tên khách hàng</p>
            <input class="form-control" type="text" />
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
          <button type="button" class="btn btn-primary">Thêm mới</button>
        </div>
      </div>
    </div>
  </div>

  <!-- MODAL XÓA-->
  <div class="modal" tabindex="-1" id="modalDel">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h3 class="modal-title">Xác nhận xóa giao dịch</h3>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="mb-3 d-flex">
            Bạn có chắc chắn muốn xóa giao dịch có mã:
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
          <button type="button" class="btn btn-danger">Xóa</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MainPage',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.content {
  margin-left: 15%;
  margin-right: 15%
}

p {
  align-items: center;
  width: 50%;
}
</style>
