import { createSlice } from "@reduxjs/toolkit";

interface UserState {
  userId: string;
  email: string;
  nickname: string;
}

const initialState: UserState = {
  userId: "",
  email: "",
  nickname: "",
};

const userSlice = createSlice({
  name: "user", // name은 selector에서 의미가 있다.
  initialState,
  reducers: {
    setUserInfo: (state, { payload: userInfo }) => {
      console.log("userInfo : " + userInfo);
      state.userId = userInfo.userId;
      state.email = userInfo.email;
      state.nickname = userInfo.nickname;
    },
  },
});

const { actions, reducer: userReducer } = userSlice;
export const { setUserInfo } = actions;
export default userReducer;
