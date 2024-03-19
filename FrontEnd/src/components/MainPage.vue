<template>
  <div class="content">
    <div class="header text-center">
      <h1>Quản lý giao dịch nhà và đất</h1>
    </div>
    <div class="body">

      <div class="d-flex justify-content-center my-5">
        <div class="col-3 me-3">
          <input class="form-control" type="text" placeholder="Nhập tên khách hàng"
            v-model="searchAndSelect.ten_khach_hang" />
        </div>
        <div class="col-2 me-3">
          <select class=" form-select" v-model="searchAndSelect.loai_dich_vu_id">
            <option v-for="service in services" :value="service.id">{{ service.ten_dich_vu }}
            </option>
          </select>
        </div>
        <div class="col-2">
          <button class="btn btn-primary " @click="search()">
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
              <th class="text-center">Cập nhật</th>
              <th class="text-center">Chi tiết</th>
              <th class="text-center">Xóa</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="transaction in transactions" :key="transaction.id">
              <td>{{ transaction.ma_giao_dich }}</td>
              <td>{{ transaction.loai_dich_vu_id.ten_dich_vu }}</td>
              <td>{{ this.formatDate(transaction.ngay_giao_dich) }}</td>
              <td>{{ transaction.don_gia.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") }}</td>
              <td>{{ transaction.dien_tich }}</td>
              <td>{{ transaction.khach_hang_id.ten_khach_hang }}</td>
              <td>{{ transaction.khach_hang_id.sdt }}</td>
              <td>{{ transaction.khach_hang_id.email }}</td>
              <td class="text-center">
                <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalUpdate"
                  @click="updateTransactionId(transaction.id)">
                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-brush"
                    viewBox="0 0 16 16">
                    <path
                      d="M15.825.12a.5.5 0 0 1 .132.584c-1.53 3.43-4.743 8.17-7.095 10.64a6.1 6.1 0 0 1-2.373 1.534c-.018.227-.06.538-.16.868-.201.659-.667 1.479-1.708 1.74a8.1 8.1 0 0 1-3.078.132 4 4 0 0 1-.562-.135 1.4 1.4 0 0 1-.466-.247.7.7 0 0 1-.204-.288.62.62 0 0 1 .004-.443c.095-.245.316-.38.461-.452.394-.197.625-.453.867-.826.095-.144.184-.297.287-.472l.117-.198c.151-.255.326-.54.546-.848.528-.739 1.201-.925 1.746-.896q.19.012.348.048c.062-.172.142-.38.238-.608.261-.619.658-1.419 1.187-2.069 2.176-2.67 6.18-6.206 9.117-8.104a.5.5 0 0 1 .596.04M4.705 11.912a1.2 1.2 0 0 0-.419-.1c-.246-.013-.573.05-.879.479-.197.275-.355.532-.5.777l-.105.177c-.106.181-.213.362-.32.528a3.4 3.4 0 0 1-.76.861c.69.112 1.736.111 2.657-.12.559-.139.843-.569.993-1.06a3 3 0 0 0 .126-.75zm1.44.026c.12-.04.277-.1.458-.183a5.1 5.1 0 0 0 1.535-1.1c1.9-1.996 4.412-5.57 6.052-8.631-2.59 1.927-5.566 4.66-7.302 6.792-.442.543-.795 1.243-1.042 1.826-.121.288-.214.54-.275.72v.001l.575.575zm-4.973 3.04.007-.005zm3.582-3.043.002.001h-.002z" />
                  </svg>
                </button>
              </td>
              <td class="text-center">
                <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalAttribute"
                  @click=detailTransactionId(transaction.id)>
                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                    class="bi bi-eye-fill " viewBox="0 0 16 16">
                    <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0" />
                    <path
                      d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8m8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7" />
                  </svg>
                </button>
              </td>
              <td class="text-center">
                <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modalDel"
                  @click="deleteTransactionId(transaction.id)">
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
          <div class="mb-2 d-flex">
            <p>Mã giao dịch:</p>
            <div>{{ detailTransaction ? detailTransaction.ma_giao_dich : '' }}</div>
          </div>
          <div class="mb-2 d-flex">
            <p>Loại dịch vụ: </p>
            <div>{{ detailTransaction ? detailTransaction.loai_dich_vu_id.ten_dich_vu : '' }}</div>
          </div>
          <div class="mb-2 d-flex">
            <p>Ngày giao dịch: </p>
            <div>{{ detailTransaction ? formatDate(detailTransaction.ngay_giao_dich) : '' }}</div>
          </div>
          <div class="mb-2 d-flex">
            <p>Đơn giá (VND/m2): </p>
            <div>{{ detailTransaction ? detailTransaction.don_gia.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") : ''
              }}</div>
          </div>
          <div class="mb-2 d-flex">
            <p>Diện tích (m2): </p>
            <div>{{ detailTransaction ? detailTransaction.dien_tich : '' }}</div>
          </div>
          <div class="mb-2 d-flex">
            <p>Tên khách hàng: </p>
            <div>{{ detailTransaction ? detailTransaction.khach_hang_id.ten_khach_hang : '' }}</div>
          </div>
          <div class="mb-2 d-flex">
            <p>Số điện thoại: </p>
            <div>{{ detailTransaction ? detailTransaction.khach_hang_id.sdt : '' }}</div>
          </div>
          <div class="mb-2 d-flex">
            <p>Email: </p>
            <div>{{ detailTransaction ? detailTransaction.khach_hang_id.email : '' }}</div>
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
            <input class="form-control" type="text" v-model="newTransaction.ma_giao_dich"
              @keyup="checkFormat(this.newTransaction.ma_giao_dich)" />
          </div>
          <div class="mb-3 text-danger" v-if="!isValidFormat">Vui lòng nhập đúng định dạng: MGD-xxxx (x: 0 - 9)</div>
          <div class="mb-3 d-flex">
            <p>Loại dịch vụ</p>
            <select class="form-select" v-model="newTransaction.loai_dich_vu_id.id">
              <option v-for="service in services" :value="service.id">{{ service.ten_dich_vu }}</option>
            </select>
          </div>
          <div class="mb-3 d-flex">
            <p>Ngày giao dịch</p>
            <input id="startDate" class="form-control" type="date" v-model="newTransaction.ngay_giao_dich"
              @change="checkDate(this.newTransaction.ngay_giao_dich)" />
          </div>
          <div class="mb-3 text-danger" v-if="!isValidDate">Ngày giao dịch phải lớn hơn thời gian hiện tại</div>
          <div class="mb-3 d-flex">
            <p>Đơn giá</p>
            <input class="number form-control" type="number" v-model="newTransaction.don_gia"
              @keyup="checkPrice(this.newTransaction.don_gia)" />
          </div>
          <div class="mb-3 text-danger" v-if="!isValidCost">Đơn giá phải lớn hơn 500,000đ</div>
          <div class="mb-3 d-flex">
            <p>Diện tích</p>
            <input class="number form-control" type="number" v-model="newTransaction.dien_tich"
              @keyup="checkArea(this.newTransaction.dien_tich)" />
          </div>
          <div class="mb-3 text-danger" v-if="!isValidArea">Diện tích phải lớn hơn 20m2</div>
          <div class="mb-3 d-flex">
            <p>Tên khách hàng</p>
            <select class="form-select" v-model="newTransaction.khach_hang_id.id">
              <option v-for="customer in customers" :value="customer.id">{{ customer.ten_khach_hang }}</option>
            </select>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
          <button type="button" class="btn btn-primary" @click="addTransaction()" data-bs-dismiss="modal">Thêm
            mới</button>
        </div>
      </div>
    </div>
  </div>

  <!-- MODAL CẬP NHẬT-->
  <div class="modal" tabindex="-1" id="modalUpdate">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h3 class="modal-title">Cập nhật giao dịch</h3>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="mb-3 d-flex">
            <p>Mã giao dịch</p>
            <input class="form-control" type="text" v-model="updateTransaction.ma_giao_dich"
              @keyup="checkFormat(this.updateTransaction.ma_giao_dich)" />
          </div>
          <div class="mb-3 text-danger" v-if="!isValidFormat">Vui lòng nhập đúng định dạng: MGD-xxxx (x: 0 - 9)</div>
          <div class="mb-3 d-flex">
            <p>Loại dịch vụ</p>
            <select class="form-select" v-model="updateTransaction.loai_dich_vu_id.id">
              <option v-for="service in services" :value="service.id">{{ service.ten_dich_vu }}</option>
            </select>
          </div>
          <div class="mb-3 d-flex">
            <p>Ngày giao dịch</p>
            <input id="startDate" class="form-control" type="date" v-model="updateTransaction.ngay_giao_dich"
              @change="checkDate(this.updateTransaction.ngay_giao_dich)" />
          </div>
          <div class="mb-3 text-danger" v-if="!isValidDate">Ngày giao dịch phải lớn hơn thời gian hiện tại</div>
          <div class="mb-3 d-flex">
            <p>Đơn giá</p>
            <input class="number form-control" type="number" v-model="updateTransaction.don_gia"
              @keyup="checkPrice(this.updateTransaction.don_gia)" />
          </div>
          <div class="mb-3 text-danger" v-if="!isValidCost">Đơn giá phải lớn hơn 500,000đ</div>
          <div class="mb-3 d-flex">
            <p>Diện tích</p>
            <input class="number form-control" type="number" v-model="updateTransaction.dien_tich"
              @keyup="checkArea(this.updateTransaction.dien_tich)" />
          </div>
          <div class="mb-3 text-danger" v-if="!isValidArea">Diện tích phải lớn hơn 20m2</div>
          <div class="mb-3 d-flex">
            <p>Tên khách hàng</p>
            <select class="form-select" v-model="updateTransaction.khach_hang_id.id">
              <option v-for="customer in customers" :value="customer.id">{{ customer.ten_khach_hang }}</option>
            </select>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
          <button type="button" class="btn btn-primary" @click="updatedTransaction()" data-bs-dismiss="modal">Cập
            nhật</button>
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
            <strong class="text-danger"> {{ selectedId ? selectedId.ma_giao_dich : "" }}</strong>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-bs-dismiss="modal" @click="confirmDelete()">Xóa</button>
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import { error } from 'jquery';
import Swal from 'sweetalert2';

export default {
  name: 'MainPage',
  data() {
    return {
      searchText: '',
      customers: [],
      services: [],
      transactions: [],
      detailTransaction: null,
      selectedId: null,
      newTransaction: {
        ma_giao_dich: '',
        loai_dich_vu_id: {
          id: null
        },
        ngay_giao_dich: '',
        don_gia: '',
        dien_tich: '',
        khach_hang_id: {
          id: null
        }
      },
      isValidFormat: true,
      isValidDate: true,
      isValidCost: true,
      isValidArea: true,

      searchAndSelect: {
        loai_dich_vu_id: "0",
        ten_khach_hang: null
      },

      transactionsSearch: [],

      updateTransaction: {
        id: null,
        ma_giao_dich: '',
        loai_dich_vu_id: {
          id: null
        },
        ngay_giao_dich: '',
        don_gia: '',
        dien_tich: '',
        khach_hang_id: {
          id: null
        }
      },
    }
  },

  mounted() {
    this.fetchData();
    this.fetchCustomers();
    this.fetchServices();
  },

  methods: {
    formatDate(dateString) {
      const date = new Date(dateString);

      const day = date.getDate();
      const month = date.getMonth() + 1;
      const year = date.getFullYear();

      const formattedDay = (day < 10) ? '0' + day : day;
      const formattedMonth = (month < 10) ? '0' + month : month;

      return formattedDay + ' - ' + formattedMonth + ' - ' + year;
    },

    resetDate(dateString) {
      const date = new Date(dateString);

      const day = date.getDate();
      const month = date.getMonth() + 1;
      const year = date.getFullYear();

      const formattedDay = (day < 10) ? '0' + day : day;
      const formattedMonth = (month < 10) ? '0' + month : month;

      return year + '-' + formattedMonth + '-' + formattedDay;
    },


    async fetchData() {
      try {
        const apiUrl = process.env.VUE_APP_URL;
        const reponse = await axios.get(apiUrl + `/api/giaodich`);
        this.transactions = reponse.data;
        this.transactionsSearch = this.transactions
        console.log(error);

      } catch (error) {
        console.error("Error fetching data:", error);
      }
    },

    async fetchCustomers() {
      try {
        const apiUrl = process.env.VUE_APP_URL;
        const response = await axios.get(apiUrl + `/api/khachhang`);
        this.customers = response.data;
      } catch (error) {
        console.error("Error fetching customers:", error);
      }
    },

    async fetchServices() {
      try {
        const apiUrl = process.env.VUE_APP_URL;
        const response = await axios.get(apiUrl + `/api/loaidichvu`);
        this.services = response.data;
      } catch (error) {
        console.error("Error fetching customers:", error);
      }
    },

    async addTransaction() {
      if (!this.newTransaction.ma_giao_dich || !this.newTransaction.loai_dich_vu_id.id || !this.newTransaction.ngay_giao_dich
        || !this.newTransaction.don_gia || !this.newTransaction.dien_tich || !this.newTransaction.khach_hang_id.id) {
        Swal.fire('Vui lòng điền đầy đủ thông tin', '', 'error');
        return;
      }
      if (!this.isValidFormat || !this.isValidDate || !this.isValidArea || !this.isValidArea) {
        Swal.fire('Vui lòng nhập đúng định dạng', 'Vui lòng thử lại sau', 'error');
        return
      }
      try {
        const apiUrl = process.env.VUE_APP_URL;
        const response = await axios.post(apiUrl + `/api/giaodich/add`, this.newTransaction);
        if (response.status === 200) {
          this.fetchData();
          Swal.fire('Thêm mới thành công', '', 'success');
          this.newTransaction.ma_giao_dich = ''
          this.newTransaction.loai_dich_vu_id = 1
          this.newTransaction.ngay_giao_dich = ''
          this.newTransaction.don_gia = ""
          this.newTransaction.dien_tich = ""
          this.newTransaction.khach_hang_id = 1
        } else {
          Swal.fire('Đã xảy ra lỗi', 'Vui lòng thử lại sau', 'error');
        }
      } catch (error) {
        console.error("Error adding transaction:", error);
        Swal.fire('Đã xảy ra lỗi', 'Vui lòng thử lại sau', 'error');
      }
    },

    detailTransactionId(transactionId) {
      this.detailTransaction = this.transactions.find(transaction => transaction.id === transactionId)
    },
    updateTransactionId(transactionId) {
      this.updateTransaction = { id: transactionId, ...this.transactions.find(transaction => transaction.id === transactionId) }
      this.updateTransaction.ngay_giao_dich = this.resetDate(this.updateTransaction.ngay_giao_dich)
    },

    deleteTransactionId(transactionId) {
      this.selectedId = this.transactions.find(transaction => transaction.id === transactionId)
    },

    async confirmDelete() {
      const deleteId = this.selectedId.id
      try {
        const apiUrl = process.env.VUE_APP_URL;
        await axios.delete(apiUrl + `/api/giaodich/${deleteId}`)

        this.transactions = this.transactions.filter(transaction => transaction.id !== deleteId);
        this.transactionsSearch = this.transactions
        Swal.fire("Xóa thành công", "", "success");
      } catch (error) {
        console.error("Error deleting transaction:", error);
        Swal.fire('Đã xảy ra lỗi', 'Vui lòng thử lại sau', 'error');
      }
    },

    checkFormat(magiaodich) {
      const regex = /^MGD-\d{4}$/;
      this.isValidFormat = regex.test(magiaodich);
      return this.isValidFormat;
    },

    checkDate(date) {
      const selectedDate = new Date(date);
      const currentDate = new Date();
      this.isValidDate = selectedDate > currentDate;
      return this.isValidDate
    },

    checkPrice(price) {
      this.isValidCost = price > 500000
      return this.isValidCost
    },

    checkArea(area) {
      this.isValidArea = area > 20
      return this.isValidArea
    },

    search() {
      const filterTransactions = this.transactionsSearch.filter((transaction) => {
        if (this.searchAndSelect.ten_khach_hang && this.searchAndSelect.loai_dich_vu_id != "0") {
          console.log("đúng 1", this.searchAndSelect);
          return (
            transaction.khach_hang_id.ten_khach_hang
              .toLowerCase()
              .includes(this.searchAndSelect.ten_khach_hang.toLowerCase()) &&
            transaction.loai_dich_vu_id.id === parseInt(this.searchAndSelect.loai_dich_vu_id)
          );
        }
        if (this.searchAndSelect.ten_khach_hang) {
          console.log("đúng 2", this.searchAndSelect);

          return transaction.khach_hang_id.ten_khach_hang
            .toLowerCase()
            .includes(this.searchAndSelect.ten_khach_hang.toLowerCase());
        }
        if (this.searchAndSelect.loai_dich_vu_id != "0") {
          return (
            transaction.loai_dich_vu_id.id === parseInt(this.searchAndSelect.loai_dich_vu_id)
          );
        }
        return true;
      });
      if (filterTransactions.length == 0) {
        Swal.fire("Không tìm thấy kết quả", "", "errors")
      } else {
        this.transactions = filterTransactions;
      }
    },

    async updatedTransaction() {
      if (!this.updateTransaction.ma_giao_dich || !this.updateTransaction.loai_dich_vu_id.id || !this.updateTransaction.ngay_giao_dich
        || !this.updateTransaction.don_gia || !this.updateTransaction.dien_tich || !this.updateTransaction.khach_hang_id.id) {
        Swal.fire('Vui lòng điền đầy đủ thông tin', '', 'error');
        return;
      }
      if (!this.isValidFormat || !this.isValidDate || !this.isValidArea || !this.isValidArea) {
        Swal.fire('Vui lòng nhập đúng định dạng', 'Vui lòng thử lại sau', 'error');
        return
      }
      try {
        const apiUrl = process.env.VUE_APP_URL;
        await axios.put(apiUrl + `/api/giaodich/update`, { id: this.updatedId, ...this.updateTransaction })
          .then(response => {
            this.fetchData()
          });
        Swal.fire({
          icon: "success",
          title: "Transaction has been updated",
        });
      } catch (error) {
        console.error("Error adding transaction:", error);
        Swal.fire('Đã xảy ra lỗi', 'Vui lòng thử lại sau', 'error');
      }

    },
  },
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

input[type=number]::-webkit-inner-spin-button,
input[type=number]::-webkit-outer-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

input[type=number] {
  -moz-appearance: textfield;
}
</style>
