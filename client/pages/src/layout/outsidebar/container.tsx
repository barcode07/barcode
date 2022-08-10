import OutSideBarPresenter from "./presenter";

const dummy = ["귀찮다", "어렵다", "구조가이게뭐냐"];

export default function OutSideBarContainer() {
  return <OutSideBarPresenter dummy={dummy} />;
}
