import * as OS from "./style";

interface IOutsideBarProps {
  dummy: string[];
}

export default function OutSideBarPresenter(props: IOutsideBarProps) {
  return (
    <OS.HTML>
      <OS.Header>아웃사이드바 헤더</OS.Header>
      <OS.Body>
        {props.dummy.map((el) => (
          <OS.example>{el}</OS.example>
        ))}
      </OS.Body>
    </OS.HTML>
  );
}
