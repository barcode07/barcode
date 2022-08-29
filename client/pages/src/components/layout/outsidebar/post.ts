import AxiosInstance from "../../../../backendTest/AxiosInstance";

export const createServer = () => {
  AxiosInstance({
    url: "/barcode/server",
    method: "POST",
    data: {
      name: "test1",
      userId: 1,
    },
  })
    .then((res) => {
      console.log(res.data);
    })
    .catch((err) => {
      console.log(err);
    });
};

export const getServer = () => {
  AxiosInstance({
    url: "/barcode/server",
    method: "GET",
  })
    .then((res) => {
      console.log(res.data);
    })
    .catch((err) => {
      console.log(err);
    });
};
