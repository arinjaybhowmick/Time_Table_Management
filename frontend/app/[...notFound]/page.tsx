import { ErrorIcon } from "../utils/icons";
import { subtitle, title } from "../utils/primitives";

export default function ErrorPage() {

  return (
    <section className="flex flex-col items-center justify-center gap-4 py-8 md:py-10">
      <div className="max-w-xl text-center justify-center items-center">
        <span className={title({ color: "yellow" })}>Oops!</span><br />
        <span className={title({ color: "yellow" })}>Something Went Wrong</span><br />
        <div className={subtitle({ class: "mt-4" })}>
          We couldn't find the page you were looking for.
        </div>
      </div>
      <div className="mt-10 animate-bounce overflow-hidden">
        <ErrorIcon />
      </div>
    </section>
  );
}
