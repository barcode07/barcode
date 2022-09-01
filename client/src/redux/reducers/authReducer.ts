import { createSlice } from "@reduxjs/toolkit";

interface AuthState {
  accessToken: String;
}

const initialState: AuthState = {
  accessToken: "",
};

const authSlice = createSlice({
  name: "auth", // name은 selector에서 의미가 있다.
  initialState,
  reducers: {
    setAccessToken: (state, { payload: accessToken }) => {
      state.accessToken = accessToken;
    },
  },
});

const { actions, reducer: authReducer } = authSlice;
export const { setAccessToken } = actions;
export default authReducer;
