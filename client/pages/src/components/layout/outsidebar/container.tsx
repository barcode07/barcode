import OutSideBarPresenter from "./presenter";

const dummy = ["귀찮다", "어렵다", "구조가이게뭐냐"];

interface IOutSideBarProps {
  onClickMoveToMain: () => void;
  onClickMoveToChannel: () => void;
}

export default function OutSideBarContainer(props: IOutSideBarProps) {
  return (
    <OutSideBarPresenter
      dummy={dummy}
      onClickMoveToMain={props.onClickMoveToMain}
      onClickMoveToChannel={props.onClickMoveToChannel}
    />
  );
}
